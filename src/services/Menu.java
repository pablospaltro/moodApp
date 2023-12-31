package services;

import entities.Chill;
import entities.Focus;
import entities.MediaContent;

import java.io.IOException;
import java.util.Scanner;
public class Menu {

    Scanner scanner = new Scanner(System.in);
    ImageScraper scraper = new ImageScraper();
    MoodMediaService moodAPI = new MoodMediaService();

    public void moodApp(){

        System.out.println("\n| moodApp |");
        System.out.println("Select your mood: \n");
        boolean backToMenu = true;

        do {

            System.out.println("FOCUS  |  CHILL\n");
            String moodSelected = scanner.nextLine();

            if (moodSelected.equalsIgnoreCase("FOCUS")){

                Focus mood = new Focus();

                try {
                    MediaContent mediaContent = moodAPI.getMediaContentForMood(mood);

                    System.out.println("\n- FOCUS background image:");
                    String imageURL = scraper.getRandomImage("workspace");
                    System.out.println(imageURL);

                    System.out.println("\n- Here's a PlayList for you");
                    System.out.println(mediaContent.getSpotifyTrackUrl());

                    mood.executeMoodAction();
                    askReturnToMenu(backToMenu);

                }   catch (IOException e) {
                    System.err.println("Error with API: " + e.getMessage());
                }


            } else if (moodSelected.equalsIgnoreCase("CHILL")) {

                Chill mood = new Chill();

                try {
                    MediaContent mediaContent = moodAPI.getMediaContentForMood(mood);

                    System.out.println("\n- CHILL background image: ");
                    String imageURL = scraper.getRandomImage("coffeehouse");
                    System.out.println(imageURL);

                    System.out.println("\n- Here's a PlayList for you");
                    System.out.println(mediaContent.getSpotifyTrackUrl());

                    mood.executeMoodAction();
                    askReturnToMenu(backToMenu);

                } catch (IOException e) {
                    System.err.println("Error with API: " + e.getMessage());
                }
            }
        } while (backToMenu);
    }

    public boolean askReturnToMenu(boolean backToMenu){
        System.out.println("\nBack to Menu? \nY | N");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")){
            backToMenu = true;
        } else if (answer.equalsIgnoreCase("N")){
            backToMenu = false;
        } else {
            System.out.println("Oops, wrong letter. Try again, please.");
        }

        return backToMenu;
    }
}
