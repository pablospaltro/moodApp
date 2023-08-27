package services;

import entities.Chill;
import entities.Focus;
import entities.MediaContent;

import java.io.IOException;
import java.util.Scanner;
public class Menu {

    Scanner scanner = new Scanner(System.in);
    MoodMediaService moodAPI = new MoodMediaService();

    public void moodApp(){

        System.out.println("| moodApp |");
        System.out.println("How are we feeling today?\n");
        boolean backToMenu = true;

        do {

            System.out.println("\nFOCUS  |  CHILL\n");
            String moodSelected = scanner.nextLine();

            if (moodSelected.equalsIgnoreCase("FOCUS")){

                Focus mood = new Focus();

                try {
                    MediaContent mediaContent = moodAPI.getMediaContentForMood(mood);

                    System.out.println("\n- You're giving this kind of vibe");
                    System.out.println(mediaContent.getImageUrl());

                    System.out.println("- Here's a PlayList for you");
                    System.out.println(mediaContent.getSpotifyTrackUrl());

                    mood.executeAction();
                    askReturnToMenu(backToMenu);

                }   catch (IOException e) {
                    System.err.println("Error with API: " + e.getMessage());
                }


            } else if (moodSelected.equalsIgnoreCase("CHILL")) {

                Chill mood = new Chill();

                try {
                    MediaContent mediaContent = moodAPI.getMediaContentForMood(mood);

                    System.out.println("\n- You're giving this kind of vibe");
                    System.out.println(mediaContent.getImageUrl());

                    System.out.println("- Here's a PlayList for you");
                    System.out.println(mediaContent.getSpotifyTrackUrl());

                    mood.executeAction();
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
