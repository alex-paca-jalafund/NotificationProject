package org.example.event;

import org.example.notification.EmailNotificationChannel;
import org.example.notification.NotificationChannel;
import org.example.notification.SmsNotificationChannel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventRouterTest {

    @Test
    void testRouteEventToEmailChannel() {
        String emailEvent = "EMAIL: Welcome to our platform!";

        NotificationChannel channel = EventRouter.routeEvent(emailEvent);

        assertNotNull(channel, "The channel should not be null for an email event.");
        assertTrue(channel instanceof EmailNotificationChannel, "The channel should be an instance of EmailNotificationChannel.");
    }

    @Test
    void testRouteEventToSmsChannel() {
        String smsEvent = "SMS: Your verification code is 1234.";

        NotificationChannel channel = EventRouter.routeEvent(smsEvent);

        assertNotNull(channel, "The channel should not be null for an SMS event.");
        assertTrue(channel instanceof SmsNotificationChannel, "The channel should be an instance of SmsNotificationChannel.");
    }

    @Test
    void testRouteEventToUnknownChannel() {
        String unknownEvent = "PUSH: You have a new message.";

        NotificationChannel channel = EventRouter.routeEvent(unknownEvent);

        assertNull(channel, "The channel should be null for an unknown event type.");
    }

    @Test
    void testRouteEventWithEmptyEvent() {
        String emptyEvent = "";

        NotificationChannel channel = EventRouter.routeEvent(emptyEvent);

        assertNull(channel, "The channel should be null for an empty event.");
    }

    @Test
    void testRouteEventWithNullEvent() {
        String nullEvent = null;

        NotificationChannel channel = EventRouter.routeEvent(nullEvent);

        assertNull(channel, "The channel should be null for a null event.");
    }
}

