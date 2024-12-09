package org.example.event;

import org.example.notification.EmailNotificationChannel;
import org.example.notification.SmsNotificationChannel;
import org.example.notification.NotificationChannel;

import java.util.Map;

/**
 * Routes events to the appropriate notification channels based on the event type.
 */
public class EventRouter {
    private static final Map<String, NotificationChannel> CHANNELS = Map.of(
            "EMAIL", new EmailNotificationChannel(),
            "SMS", new SmsNotificationChannel()
    );

    /**
     * Routes the event to the corresponding notification channel based on the event type.
     *
     * @param event The event to be routed.
     * @return The corresponding NotificationChannel if found, null otherwise.
     */
    public static NotificationChannel routeEvent(String event) {
        if (event != null) {
            if (event.startsWith("EMAIL")) {
                return CHANNELS.get("EMAIL");
            } else if (event.startsWith("SMS")) {
                return CHANNELS.get("SMS");
            }
        }
        return null;
    }
}
