package org.example.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsNotificationChannel implements NotificationChannel {
    private static final Logger logger = LoggerFactory.getLogger(SmsNotificationChannel.class);

    @Override
    public void sendNotification(String message) {
        logger.info("Sending SMS: {}", message);
    }
}
