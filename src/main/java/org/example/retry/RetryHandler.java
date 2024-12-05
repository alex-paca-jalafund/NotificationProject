package org.example.retry;

import org.example.notification.NotificationChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryHandler {
    private static final Logger logger = LoggerFactory.getLogger(RetryHandler.class);

    public static void retryNotification(String message, NotificationChannel channel) {
        int retries = 0;
        while (retries < 3) {
            try {
                logger.info("Intentando reintento para el mensaje: " + message);
                channel.sendNotification(message);
                logger.info("Reintento exitoso para el mensaje: " + message);
                return;
            } catch (Exception e) {
                retries++;
                logger.error("Error en reintento " + retries + " para el mensaje: " + message, e);
            }
        }
        logger.error("Todos los intentos fallaron para el mensaje: " + message);
    }
}