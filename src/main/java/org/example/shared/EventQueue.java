package org.example.shared;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueue {
    private static final BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>();

    public static BlockingQueue<String> getQueue() {
        return QUEUE;
    }
}
