package org.example.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class EventQueueTest {

    private BlockingQueue<String> customQueue;

    @BeforeEach
    void setUp() {
        customQueue = new LinkedBlockingQueue<>();
    }

    @Test
    void testGetQueueDefault() {
        BlockingQueue<String> queue = EventQueue.getQueue();
        assertNotNull(queue);
        assertTrue(queue instanceof LinkedBlockingQueue);
    }

    @Test
    void testSetQueue() {
        EventQueue.setQueue(customQueue);
        BlockingQueue<String> queue = EventQueue.getQueue();
        assertSame(customQueue, queue);
    }

    @Test
    void testQueueSize() throws InterruptedException {
        BlockingQueue<String> queue = EventQueue.getQueue();
        queue.put("Test Event 1");
        queue.put("Test Event 2");
        assertEquals(2, queue.size());
    }

    @Test
    void testSetCustomQueue() {
        BlockingQueue<String> queue = EventQueue.getQueue();
        EventQueue.setQueue(customQueue);
        assertNotSame(queue, customQueue);
    }
}
