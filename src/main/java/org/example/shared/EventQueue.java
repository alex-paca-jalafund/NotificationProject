package org.example.shared;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Provides a shared event queue for producing and consuming events.
 */
public class EventQueue {
    private static BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>();

    /**
     * Retrieves the shared event queue.
     *
     * @return The current event queue.
     */
    public static BlockingQueue<String> getQueue() {
        return QUEUE;
    }

    /**
     * Sets a custom event queue to replace the default queue.
     *
     * @param customQueue The custom queue to be used.
     */
    public static void setQueue(BlockingQueue<String> customQueue) {
        QUEUE = customQueue;
    }
}
