package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class Fichier {

	private Resource resourceSmall;
	private Resource resourceCv24;

    public Fichier() {
        this.resourceSmall = new DefaultResourceLoader().getResource("SmallCV.xml");
        this.resourceCv24 = new DefaultResourceLoader().getResource("Cv24.xml");
    }

    public String loadFileXMLSmallCv() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = resourceSmall.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line+" \n");
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            return "Erreur lors du chargement du fichier : " + e.getMessage();
        }
        return content.toString();
    }
    
    public String loadFileXMLCv24() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = resourceCv24.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line+" \n");
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            return "Erreur lors du chargement du fichier : " + e.getMessage();
        }
        return content.toString();
    }

}
