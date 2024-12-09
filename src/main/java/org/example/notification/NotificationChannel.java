package org.example.notification;

/**
 * Represents a notification channel for sending notifications.
 */
public interface NotificationChannel {

    /**
     * Sends a notification message through the channel.
     *
     * @param message The notification message to be sent.
     */
    void sendNotification(String message);
}
