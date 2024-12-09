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
        logger.info("Starting event consumer...");

        executorService.submit(() -> {
            while (true) {
                try {
                    String event = EventQueue.getQueue().take();
                    logger.info("Received event: {}", event);
                    executorService.submit(() -> processEvent(event));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Error consuming event from queue", e);
                    break;
                }
            }
        });
    }

    private void processEvent(String event) {
        logger.info("Processing event: {}", event);
        try {
            Thread.sleep(1000);
            NotificationDispatcher.dispatch(event);
            logger.info("Event processed: {}", event);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Processing interrupted for event: {}", event, e);
        }
    }
}
