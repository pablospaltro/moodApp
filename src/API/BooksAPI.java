package API;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BooksAPI {

    // getting random books in the chill mode
    Scanner scan = new Scanner(System.in);
    /*
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("books.link")).build();
    */

    public void requestingBooksAPI (){
        /*
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            String responseBody = response.body();

            if (statusCode != 200){
                throw new RuntimeException ("Error during data reception : "+ statusCode);
            } else {
                //System.out.println("Respuesta JSON completa: " + responseBody);

                JSONObject jsonResponse = new JSONObject(responseBody);

                if (jsonResponse.has("book")) {
                    String joke = jsonResponse.getString("book");
                    System.out.println("\nSUSAN: \n" + joke);
                } else if (jsonResponse.has("setup") && jsonResponse.has("delivery")){
                    String setup = jsonResponse.getString("setup");
                    String delivery = jsonResponse.getString("delivery");
                    System.out.println("\nSUSAN: \n" + setup);
                    System.out.println(delivery);
                } else {
                    System.out.println("'book', 'setup' or 'delivery' not found in JSON.");
                }

            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
         */
    }

    public void chattingWithSusan (){
        System.out.println("SUSAN: ");
        System.out.println("Oh, hi there. Yeah, you can join me.");
        System.out.println("Oh, you don't have a seat! Let me remove those books and place them here. I always carry these bad boys every way I go, ha!");

        System.out.println("SUSAN: ");
        System.out.println("There you go, make yourself comfortable. Oh, I see you're curious bout my books, you can ask me about them, I love to get into books nerdyland, ha ha.\n");

        //Got to get the books API link...
        //requestingBooksAPI();
        //getMeAnotherBook();
    }

    public void getMeAnotherBook(){

        boolean anotherJoke = true;

        do {
            System.out.println("\nSUSAN:\nDo you want another book?\n");
            System.out.println("1 | Yes, please.");
            System.out.println("2 | No, thanks. See you, Susan.");
            int option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                requestingBooksAPI();
            } else {
                System.out.println("\nSUSAN:\nGoodbye, dear.\n");
                anotherJoke = false;
            }
        } while(anotherJoke);
    }

}
