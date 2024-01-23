package org.example.http;

import java.net.HttpURLConnection;
import java.net.URL;


public class HttpStatusChecker {
    private static final String URL_CAT = "https://http.cat/";

    public String getStatusImage(int code) {
        int responseCode;
        try {

            URL url = new URL(URL_CAT + code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            responseCode = connection.getResponseCode();

        } catch (Exception e) {
            return null;
        }
        if(responseCode == HttpURLConnection.HTTP_OK){
            return URL_CAT+code;
        }
        return null;
    }
}
