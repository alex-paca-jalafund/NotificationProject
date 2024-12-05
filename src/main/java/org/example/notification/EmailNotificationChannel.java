package org.example.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificationChannel implements NotificationChannel {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationChannel.class);

    @Override
    public void sendNotification(String message) {
        // Implementación real de envío de email
        logger.info("📧 Enviando email: " + message);
    }
}