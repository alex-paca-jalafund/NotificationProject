package org.example.event;

import org.example.shared.EventQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.jupiter.api.Assertions.*;

class EventProducerTest {

    private EventProducer eventProducer;
    private BlockingQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedBlockingDeque<>();
        EventQueue.setQueue(queue);
        eventProducer = new EventProducer();
    }

    @Test
    void testSendEventAddsMessageToQueue() throws InterruptedException {
        String message = "Test Event";

        eventProducer.sendEvent(message);

        assertEquals(1, queue.size(), "Queue should contain one event.");
        assertEquals(message, queue.take(), "The message in the queue should match the sent event.");
    }

    @Test
    void testSendEventAddsMultipleMessagesToQueue() throws InterruptedException {
        String message1 = "Event 1";
        String message2 = "Event 2";

        eventProducer.sendEvent(message1);
        eventProducer.sendEvent(message2);

        assertEquals(2, queue.size(), "Queue should contain two events.");
        assertEquals(message1, queue.take(), "The first message should match the first sent event.");
        assertEquals(message2, queue.take(), "The second message should match the second sent event.");
    }
}
