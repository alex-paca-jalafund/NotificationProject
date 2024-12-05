package org.example.event;

import com.rabbitmq.client.*;
import org.example.configuration.RabbitMQConfig;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventConsumer {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void startListening() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitMQConfig.HOST);

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(RabbitMQConfig.QUEUE_NAME, true, false, false, null);

            System.out.println("📥 Esperando mensajes en la cola: " + RabbitMQConfig.QUEUE_NAME);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("🔄 Evento recibido: " + message);

                executorService.submit(() -> processEvent(message));
            };

            channel.basicConsume(RabbitMQConfig.QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processEvent(String event) {
        System.out.println("📤 Procesando evento: " + event);
        try {
            Thread.sleep(1000); // Simula el procesamiento
            System.out.println("✅ Evento procesado: " + event);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

