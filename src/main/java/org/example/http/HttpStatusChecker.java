package org.example.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String URL_CAT = "https://http.cat/";

    public String getStatusImage(int code) throws Exception {
        URL url = new URL(URL_CAT + code);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("No image available for this status code");
        }

        return URL_CAT + code;
    }
}
