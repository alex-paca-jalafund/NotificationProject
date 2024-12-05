package org.example.event;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.example.configuration.RabbitMQConfig;

public class EventProducer {

    public void sendEvent(String message) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitMQConfig.HOST);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declarar Exchange y Cola
            channel.exchangeDeclare(RabbitMQConfig.EXCHANGE_NAME, "topic", true);
            channel.queueDeclare(RabbitMQConfig.QUEUE_NAME, true, false, false, null);
            channel.queueBind(RabbitMQConfig.QUEUE_NAME, RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY);

            // Enviar mensaje
            channel.basicPublish(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, null, message.getBytes());
            System.out.println("✅ Evento enviado: " + message);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error al enviar evento.");
        }
    }
}

