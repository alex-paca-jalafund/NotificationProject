package org.example.event;

import org.example.shared.EventQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EventProducer {
    private static final Logger logger = LoggerFactory.getLogger(EventProducer.class);

    public void sendEvent(String message) {
        try {
            EventQueue.getQueue().put(message);
            logger.info("Evento enviado a la cola: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Error al enviar evento a la cola.", e);
        }
    }
}