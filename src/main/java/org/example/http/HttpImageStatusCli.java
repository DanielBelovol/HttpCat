package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        System.out.print("Enter an HTTP status code:");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();


        String regex = "\\d+";
        String status = new HttpStatusChecker().getStatusImage(Integer.parseInt(code));
        if(!code.matches(regex)){
            System.out.println("Please enter valid number");
        }else if(status == null){
            System.out.println("There is not image for HTTP status "+ code);
        }else{
            new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(code));
        }
    }
}
