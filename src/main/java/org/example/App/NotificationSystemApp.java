package org.example.App;

import org.apache.log4j.BasicConfigurator;
import org.example.dispatcher.NotificationSender;
import org.example.event.EventConsumer;
import org.example.event.EventProducer;
import org.example.ui.ConsoleUI;

public class NotificationSystemApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        ConsoleUI consoleUI = new ConsoleUI();
        NotificationSender notificationSender = new NotificationSender();

        consoleUI.start(notificationSender);

//        EventConsumer consumer = new EventConsumer();
//        consumer.startListening();
//
//        EventProducer producer = new EventProducer();
//        producer.sendEvent("EMAIL: Hello via Email!");
//        producer.sendEvent("SMS: Hello via SMS!");
//        producer.sendEvent("EMAIL: Another email notification!");
//        producer.sendEvent("SMS: Another SMS notification!");
    }
}
