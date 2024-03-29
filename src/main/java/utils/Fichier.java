package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class Fichier {

	private Resource resource;

    public Fichier() {
        this.resource = new DefaultResourceLoader().getResource("SmallCV.xml");
    }

    public String loadFileXML() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            return "Erreur lors du chargement du fichier : " + e.getMessage();
        }
        return content.toString();
    }

}
