package org.example.shared;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueue {
    private static BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>();

    public static BlockingQueue<String> getQueue() {
        return QUEUE;
    }

    public static void setQueue(BlockingQueue<String> customQueue) {
        QUEUE = customQueue;
    }
}
