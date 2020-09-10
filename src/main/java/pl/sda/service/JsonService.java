package pl.sda.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class JsonService {
    public static String get(String path){
        try {
            final URL testUrl = new URL(path);
            StringBuilder jsonText = new StringBuilder();
            try (InputStream myInputStream = testUrl.openStream();
                 Scanner scan = new Scanner(myInputStream)
            ) {
                while (scan.hasNextLine()) {
                    jsonText.append(scan.nextLine());
                }
                return jsonText.toString();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    }

