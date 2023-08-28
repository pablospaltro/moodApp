package services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Random;

public class ImageScraper {
    String keyword = "workspace";
    String url = "https://www.ejemplo.com/buscar?q=" + keyword;

    public void gettingBackgroundImage() {

        try {
            Document document = Jsoup.connect(url).get();
            Elements imgElements = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");


            if (!imgElements.isEmpty()) {
                int randomIndex = new Random().nextInt(imgElements.size());
                Element imgElement = imgElements.get(randomIndex);
                String imageUrl = imgElement.absUrl("src");
                System.out.println("URL de la imagen: " + imageUrl);
            } else {
                System.out.println("No se encontraron imágenes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

