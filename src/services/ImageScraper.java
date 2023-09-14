package services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class ImageScraper {
    private final String accessKey = "YxuW9MEs1--2Zm-d7Oc5R6OibxU2-mc02HbRCE9GsAU";
    private final Random random = new Random();

    public String getRandomImage(String keyword) {
        try {
            int page = random.nextInt(10) + 1;
            String apiUrl = "https://api.unsplash.com/search/photos?page=" + page + "&query=" + keyword;

            // Crear una conexión HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Client-ID " + accessKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return apiUrl;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

