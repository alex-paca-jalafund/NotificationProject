package org.example.event;

import org.example.notification.EmailNotificationChannel;
import org.example.notification.SmsNotificationChannel;
import org.example.notification.NotificationChannel;

import java.util.Map;

public class EventRouter {
    private static final Map<String, NotificationChannel> CHANNELS = Map.of(
            "email", new EmailNotificationChannel(),
            "sms", new SmsNotificationChannel()
    );

    public static NotificationChannel routeEvent(String eventType) {
        // Lógica para decidir el canal según el tipo de evento
        if (eventType.contains("EMAIL")) {
            return CHANNELS.get("email");
        } else if (eventType.contains("SMS")) {
            return CHANNELS.get("sms");
        }
        return null;
    }
}

