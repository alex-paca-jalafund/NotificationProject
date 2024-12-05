package org.example.event;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.example.configuration.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventProducer {
    private static final Logger logger = LoggerFactory.getLogger(EventProducer.class);

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
            logger.info("✅ Evento enviado: " + message);

        } catch (Exception e) {
            logger.error("❌ Error al enviar evento.", e);
        }
    }
}
