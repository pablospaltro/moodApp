package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONObject;

public class JokesAPI {

    // getting random jokes in the chill mode
    Scanner scan = new Scanner(System.in);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v2.jokeapi.dev/joke/Any")).build();

    public void requestingJokesAPI (){

        try {
            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();

            if (statusCode != 200){
                throw new RuntimeException ("Error during data reception : "+ statusCode);
            } else {
                //System.out.println("Respuesta JSON completa: " + responseBody);

                JSONObject jsonResponse = new JSONObject(responseBody);

                if (jsonResponse.has("joke")) {
                    String joke = jsonResponse.getString("joke");
                    System.out.println("\nJACK: \n" + joke);
                } else if (jsonResponse.has("setup") && jsonResponse.has("delivery")){
                    String setup = jsonResponse.getString("setup");
                    String delivery = jsonResponse.getString("delivery");
                    System.out.println("\nJACK: \n" + setup);
                    System.out.println(delivery);
                    } else {
                    System.out.println("'joke', 'setup' or 'delivery' not found in JSON.");
                }

            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public void chattingWithJack (){
        System.out.println("JACK: ");
        System.out.println("Hey, how you doin? Come have a sit and join me for some Irish Coffee, he he! Kafi! Fill those for us, would ya?");
        System.out.println("Good old Kafi! Best coffee in town. Hey, listen to this:\n");

        requestingJokesAPI();
        tellMeAnotherJoke();
    }

    public void tellMeAnotherJoke(){

        boolean anotherJoke = true;

        do {
            System.out.println("\nJACK:\nWanna hear another joke?\n");
            System.out.println("1 | Hahaha, tell me another");
            System.out.println("2 | Oh, look at the time, I got to go! See you, Jack.");
            int option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                requestingJokesAPI();
            } else {
                System.out.println("\nJACK:\nSure, buddy! Good to see you.\n");
                anotherJoke = false;
            }
        } while(anotherJoke);
    }
}
