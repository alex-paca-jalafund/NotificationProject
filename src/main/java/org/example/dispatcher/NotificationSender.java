package org.example.dispatcher;

import org.example.event.EventProducer;

public class NotificationSender {

    private final EventProducer eventProducer;

    public NotificationSender() {
        this.eventProducer = new EventProducer();
    }

    public void sendEmailNotification(String message) {
        eventProducer.sendEvent("EMAIL: " + message);
        NotificationDispatcher.dispatch("EMAIL: " + message);
    }

    public void sendSmsNotification(String message) {
        eventProducer.sendEvent("SMS: " + message);
        NotificationDispatcher.dispatch("SMS: " + message);
    }
}
