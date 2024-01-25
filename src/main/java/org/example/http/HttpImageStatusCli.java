package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.print("Enter an HTTP status code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

        String regex = "\\d+";
        if (!code.matches(regex)) {
            System.out.println("Please enter a valid number");
            return;
        }

        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            String status = checker.getStatusImage(Integer.parseInt(code));
            new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(code));
        } catch (Exception e) {
            System.out.println("There is no image for HTTP status " + code);
        }
    }
}
