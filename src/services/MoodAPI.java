// Paquete "servicios"
package services;

import entities.Mood;
import entities.MediaContent;

import java.io.IOException;

public class MoodAPI {
    public MediaContent getMediaContentForMood(Mood mood) throws IOException {
        String imageUrl = getImageForMood(mood.getName());
        String spotifyTrackUrl = getSpotifyTrackForMood(mood.getName());
        return new MediaContent(imageUrl, spotifyTrackUrl);
    }

    private String getImageForMood(String mood) throws IOException {
        return "https://example.com/image.jpg";
    }

    private String getSpotifyTrackForMood(String mood) throws IOException {
        return "https://open.spotify.com/track/12345";
    }
}
