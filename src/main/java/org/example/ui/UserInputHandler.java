package org.example.ui;

import java.util.Scanner;

public class UserInputHandler {

    private final Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getOptionFromUser() {
        System.out.println("Select notification type:");
        System.out.println("1. Send Email");
        System.out.println("2. Send SMS");
        System.out.println("3. Exit");
        System.out.print("Option: ");
        return scanner.nextLine();
    }

    public String getMessageFromUser() {
        System.out.print("Enter your message: ");
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
