package entities;

public class MediaContent {

    private String imageUrl;
    private String spotifyTrackUrl;

    public MediaContent(String imageUrl, String spotifyTrackUrl) {
        this.imageUrl = imageUrl;
        this.spotifyTrackUrl = spotifyTrackUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSpotifyTrackUrl() {
        return spotifyTrackUrl;
    }
}
