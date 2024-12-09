package org.example.event;

import org.example.shared.EventQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.jupiter.api.Assertions.*;

class EventConsumerTest {

    private EventConsumer eventConsumer;
    private BlockingQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedBlockingDeque<>();
        EventQueue.setQueue(queue);
        eventConsumer = new EventConsumer();
    }

    @Test
    void testStartListeningProcessesEvents() throws InterruptedException {
        queue.put("Event1");
        queue.put("Event2");

        Thread consumerThread = new Thread(eventConsumer::startListening);
        consumerThread.start();

        Thread.sleep(3000);
        consumerThread.interrupt();
        System.out.println(queue.size());
        assertTrue(queue.isEmpty(), "The queue should be empty after processing all events.");
    }

    @Test
    void testStartListeningHandlesEmptyQueueGracefully() throws InterruptedException {
        Thread consumerThread = new Thread(eventConsumer::startListening);
        consumerThread.start();

        Thread.sleep(2000);
        consumerThread.interrupt();

        assertTrue(consumerThread.isInterrupted(), "The consumer thread should handle interruption gracefully.");
    }

    @Test
    void testStartListeningProcessesLargeNumberOfEvents() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            queue.put("Event " + i);
        }

        Thread consumerThread = new Thread(eventConsumer::startListening);
        consumerThread.start();

        Thread.sleep(5000);
        consumerThread.interrupt();
        System.out.println(queue.size());

        assertTrue(queue.isEmpty(), "The queue should be empty after processing a large number of events.");
    }
}
