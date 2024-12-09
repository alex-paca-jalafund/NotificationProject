package org.example.ui;

import org.example.dispatcher.NotificationSender;

/**
 * Console-based user interface for interacting with the notification system.
 */
public class ConsoleUI {

    private final UserInputHandler userInputHandler;

    /**
     * Initializes the ConsoleUI with a UserInputHandler to process user input.
     */
    public ConsoleUI() {
        this.userInputHandler = new UserInputHandler();
    }

    /**
     * Starts the user interface, allowing the user to send notifications via email or SMS.
     *
     * @param notificationSender The NotificationSender used to send notifications.
     */
    public void start(NotificationSender notificationSender) {
        String option;
        String message;

        while (true) {
            option = userInputHandler.getOptionFromUser();
            if ("3".equals(option)) {
                System.out.println("Exiting the system...");
                break;
            }

            if (!"1".equals(option) && !"2".equals(option)) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            message = userInputHandler.getMessageFromUser();

            switch (option) {
                case "1":
                    notificationSender.sendEmailNotification(message);
                    break;
                case "2":
                    notificationSender.sendSmsNotification(message);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            System.out.println("Message sent.");
        }

        userInputHandler.close();
    }
}
