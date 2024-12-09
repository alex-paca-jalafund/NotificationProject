package org.example.event;

import org.example.notification.EmailNotificationChannel;
import org.example.notification.SmsNotificationChannel;
import org.example.notification.NotificationChannel;

import java.util.Map;

public class EventRouter {
    private static final Map<String, NotificationChannel> CHANNELS = Map.of(
            "EMAIL", new EmailNotificationChannel(),
            "SMS", new SmsNotificationChannel()
    );

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
