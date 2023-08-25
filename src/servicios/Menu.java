package servicios;

import entidades.Mood;
import entidades.MediaContent;
import servicios.MoodService;

import java.io.IOException;
import java.util.Scanner;
public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void moodApp(){

        System.out.println("Bienvenido a MoodMusicApp!");
        System.out.println("Por favor, elige un estado de ánimo/sentimiento/clima:");
        String moodName = scanner.nextLine();

        MoodService moodService = new MoodService();
        Mood mood = new Mood(moodName);

        try {
            MediaContent mediaContent = moodService.getMediaContentForMood(mood);

            System.out.println("Aquí tienes una imagen relacionada:");
            System.out.println(mediaContent.getImageUrl());

            System.out.println("Aquí tienes una canción o lista de reproducción relacionada:");
            System.out.println(mediaContent.getSpotifyTrackUrl());
        } catch (IOException e) {
            System.err.println("Error al obtener datos de la API: " + e.getMessage());
        }
    }
}
