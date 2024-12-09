package org.example.dispatcher;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

class NotificationSenderTest {

    @Test
    void testSendEmailNotification() {
        try (MockedStatic<NotificationDispatcher> mockedDispatcher = mockStatic(NotificationDispatcher.class)) {
            NotificationSender sender = new NotificationSender();

            sender.sendEmailNotification("Test Email");

            mockedDispatcher.verify(() -> NotificationDispatcher.dispatch("EMAIL: Test Email"), times(1));
        }
    }

    @Test
    void testSendSmsNotification() {
        try (MockedStatic<NotificationDispatcher> mockedDispatcher = mockStatic(NotificationDispatcher.class)) {
            NotificationSender sender = new NotificationSender();

            sender.sendSmsNotification("Test SMS");

            mockedDispatcher.verify(() -> NotificationDispatcher.dispatch("SMS: Test SMS"), times(1));
        }
    }
}
