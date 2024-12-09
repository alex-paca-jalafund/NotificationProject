package org.example.dispatcher;

import org.example.event.EventProducer;

/**
 * Sends notifications via different channels (Email, SMS) by producing events
 * and dispatching them to the appropriate handlers.
 */
public class NotificationSender {

    private final EventProducer eventProducer;

    /**
     * Constructs a NotificationSender instance and initializes the EventProducer.
     */
    public NotificationSender() {
        this.eventProducer = new EventProducer();
    }

    /**
     * Sends an email notification by producing an email event and dispatching it.
     *
     * @param message The notification message to be sent via email.
     */
    public void sendEmailNotification(String message) {
        eventProducer.sendEvent("EMAIL: " + message);
        NotificationDispatcher.dispatch("EMAIL: " + message);
    }

    /**
     * Sends an SMS notification by producing an SMS event and dispatching it.
     *
     * @param message The notification message to be sent via SMS.
     */
    public void sendSmsNotification(String message) {
        eventProducer.sendEvent("SMS: " + message);
        NotificationDispatcher.dispatch("SMS: " + message);
    }
}
