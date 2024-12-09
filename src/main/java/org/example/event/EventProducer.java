package org.example.event;

import org.example.shared.EventQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Produces events and sends them to the event queue for processing.
 */
public class EventProducer {
    private static final Logger logger = LoggerFactory.getLogger(EventProducer.class);

    /**
     * Sends an event message to the event queue.
     *
     * @param message The event message to be sent to the queue.
     */
    public void sendEvent(String message) {
        try {
            EventQueue.getQueue().put(message);
            logger.info("Event sent to queue: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Error sending event to queue", e);
        }
    }
}
