package org.example.event;

import com.rabbitmq.client.*;
import org.example.configuration.RabbitMQConfig;
import org.example.dispatcher.NotificationDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventConsumer {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void startListening() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitMQConfig.HOST);

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(RabbitMQConfig.QUEUE_NAME, true, false, false, null);
            logger.info("📥 Esperando mensajes en la cola: " + RabbitMQConfig.QUEUE_NAME);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                logger.info("🔄 Evento recibido: " + message);
                executorService.submit(() -> processEvent(message));
            };

            channel.basicConsume(RabbitMQConfig.QUEUE_NAME, true, deliverCallback, consumerTag -> {});

        } catch (Exception e) {
            logger.error("❌ Error al iniciar el consumidor.", e);
        }
    }

    private void processEvent(String event) {
        logger.info("📤 Procesando evento: " + event);
        try {
            // Simula el procesamiento
            Thread.sleep(1000);
            logger.info("✅ Evento procesado: " + event);
            NotificationDispatcher.dispatch(event); // Enviar notificación
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("🔄 Procesamiento interrumpido para el evento: " + event, e);
        }
    }
}
