package org.example.http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {

        File pathToImg = new File("src/main/resources/imgWithHttpStatusCode" + code + ".jpg");

        try (BufferedInputStream in = new BufferedInputStream(new URL(new HttpStatusChecker().getStatusImage(code)).openStream());
             FileOutputStream fos = new FileOutputStream(pathToImg)) {

            byte[] data = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error downloading image: " + e.getMessage(), e);
        }
    }
}
