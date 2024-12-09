package org.example.dispatcher;

import org.example.event.EventRouter;
import org.example.notification.NotificationChannel;
import org.example.retry.RetryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the dispatch of notifications to appropriate channels based on events.
 */
public class NotificationDispatcher {
    private static final Logger logger = LoggerFactory.getLogger(NotificationDispatcher.class);

    /**
     * Dispatches a notification message to the appropriate notification channel.
     * If an error occurs during sending, it attempts to retry sending the notification.
     *
     * @param message The notification message to be sent.
     */
    public static void dispatch(String message) {
        NotificationChannel channel = EventRouter.routeEvent(message);
        if (channel != null) {
            try {
                channel.sendNotification(message);
                logger.info("Notification sent by: " + channel.getClass().getSimpleName());
            } catch (Exception e) {
                logger.error("Error sending notification:", e);
                RetryHandler.retryNotification(message, channel);
            }
        } else {
            logger.warn("No notification channel was found for the event: " + message);
        }
    }
}
