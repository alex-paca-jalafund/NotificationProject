package org.example.ui;

import org.example.dispatcher.NotificationSender;

public class ConsoleUI {

    private final UserInputHandler userInputHandler;

    public ConsoleUI() {
        this.userInputHandler = new UserInputHandler();
    }

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
