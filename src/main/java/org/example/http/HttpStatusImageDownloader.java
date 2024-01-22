package org.example.http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusImageDownloader {
    private int counterForFile = 0;
    public void downloadStatusImage(int code){
        File pathToImg = new File("src/main/resources/imgWithHttpStatusCode"+String.valueOf(code)+".jpg");
        HttpStatusChecker statusChecker = new HttpStatusChecker();


        FileOutputStream fos = null;
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new URL(statusChecker.getStatusImage(code)).openStream());
            fos = new FileOutputStream(pathToImg);
            byte[] data = new byte[1024];
            int count;
            while((count = in.read(data,0,1024)) != -1){
                fos.write(data,0,count);
                fos.flush();
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            counterForFile++;
            try{
                in.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
