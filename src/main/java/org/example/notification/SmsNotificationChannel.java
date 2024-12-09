package org.example.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the SMS notification channel for sending SMS notifications.
 */
public class SmsNotificationChannel implements NotificationChannel {
    private static final Logger logger = LoggerFactory.getLogger(SmsNotificationChannel.class);

    /**
     * Sends the notification message via SMS.
     *
     * @param message The notification message to be sent via SMS.
     */
    @Override
    public void sendNotification(String message) {
        logger.info("Sending SMS: {}", message);
    }
}
