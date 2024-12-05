package org.example.event;

import org.example.dispatcher.NotificationDispatcher;
import org.example.shared.EventQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventConsumer {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void startListening() {
        logger.info("Iniciando consumidor de eventos...");

        executorService.submit(() -> {
            while (true) {
                try {
                    // Obtener evento de la cola
                    String event = EventQueue.getQueue().take();
                    logger.info("Evento recibido: " + event);

                    // Procesar evento de forma asíncrona
                    executorService.submit(() -> processEvent(event));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Error al consumir evento de la cola.", e);
                    break;
                }
            }
        });
    }

    private void processEvent(String event) {
        logger.info("Procesando evento: " + event);
        try {
            Thread.sleep(1000); // Simula el procesamiento
            NotificationDispatcher.dispatch(event);
            logger.info("Evento procesado: " + event);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Procesamiento interrumpido para el evento: " + event, e);
        }
    }
}
