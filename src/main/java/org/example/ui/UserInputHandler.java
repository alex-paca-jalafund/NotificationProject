package org.example.ui;

import java.util.Scanner;

/**
 * Handles user input for selecting notification types and entering message content.
 */
public class UserInputHandler {

    private final Scanner scanner;

    /**
     * Initializes the UserInputHandler with a scanner for capturing user input.
     */
    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to select a notification type.
     *
     * @return The selected option as a string.
     */
    public String getOptionFromUser() {
        System.out.println("Select notification type:");
        System.out.println("1. Send Email");
        System.out.println("2. Send SMS");
        System.out.println("3. Exit");
        System.out.print("Option: ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a message for the notification.
     *
     * @return The entered message as a string.
     */
    public String getMessageFromUser() {
        System.out.print("Enter your message: ");
        return scanner.nextLine();
    }

    /**
     * Closes the scanner resource when no longer needed.
     */
    public void close() {
        scanner.close();
    }
}
