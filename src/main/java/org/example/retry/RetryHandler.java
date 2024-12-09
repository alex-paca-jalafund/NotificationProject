package org.example.retry;

import org.example.notification.NotificationChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles retrying the sending of notifications in case of failure.
 */
public class RetryHandler {
    private static final Logger logger = LoggerFactory.getLogger(RetryHandler.class);

    /**
     * Attempts to resend the notification message up to 3 times if it fails.
     *
     * @param message The notification message to be retried.
     * @param channel The notification channel through which the message is sent.
     */
    public static void retryNotification(String message, NotificationChannel channel) {
        int retries = 0;
        while (retries < 3) {
            try {
                logger.info("Retrying message: {}", message);
                channel.sendNotification(message);
                logger.info("Retry successful for message: {}", message);
                return;
            } catch (Exception e) {
                retries++;
                logger.error("Retry {} failed for message: {}", retries, message, e);
            }
        }
        logger.error("All retry attempts failed for message: {}", message);
    }
}
