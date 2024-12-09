package org.example.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the email notification channel for sending email notifications.
 */
public class EmailNotificationChannel implements NotificationChannel {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationChannel.class);

    /**
     * Sends the notification message via email.
     *
     * @param message The notification message to be sent via email.
     */
    @Override
    public void sendNotification(String message) {
        logger.info("Sending email: {}", message);
    }
}
