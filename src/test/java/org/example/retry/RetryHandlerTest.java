package org.example.retry;

import org.example.notification.NotificationChannel;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class RetryHandlerTest {

    @Test
    void testRetryNotification_successOnFirstAttempt() {
        NotificationChannel mockChannel = mock(NotificationChannel.class);

        RetryHandler.retryNotification("Test Message", mockChannel);

        verify(mockChannel, times(1)).sendNotification("Test Message");
    }

    @Test
    void testRetryNotification_failureAfterThreeAttempts() {
        NotificationChannel mockChannel = mock(NotificationChannel.class);
        doThrow(new RuntimeException("Test Exception")).when(mockChannel).sendNotification("Test Message");

        RetryHandler.retryNotification("Test Message", mockChannel);

        verify(mockChannel, times(3)).sendNotification("Test Message");
    }
}
