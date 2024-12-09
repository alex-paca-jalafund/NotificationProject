package org.example.dispatcher;

import org.example.event.EventRouter;
import org.example.notification.NotificationChannel;
import org.example.retry.RetryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class NotificationDispatcherTest {

    private MockedStatic<EventRouter> eventRouterMock;
    private MockedStatic<RetryHandler> retryHandlerMock;

    @BeforeEach
    void setup() {
        eventRouterMock = Mockito.mockStatic(EventRouter.class);
        retryHandlerMock = Mockito.mockStatic(RetryHandler.class);
    }

    @Test
    void testDispatchWithValidChannel() {
        NotificationChannel mockChannel = mock(NotificationChannel.class);

        eventRouterMock.when(() -> EventRouter.routeEvent("EMAIL: Test Message"))
                .thenReturn(mockChannel);

        NotificationDispatcher.dispatch("EMAIL: Test Message");

        verify(mockChannel, times(1)).sendNotification("EMAIL: Test Message");
        eventRouterMock.close();
        retryHandlerMock.close();
    }

    @Test
    void testDispatchWithNullChannel() {
        eventRouterMock.when(() -> EventRouter.routeEvent("UNKNOWN: Test Message"))
                .thenReturn(null);

        NotificationDispatcher.dispatch("UNKNOWN: Test Message");

        retryHandlerMock.verifyNoInteractions();
        eventRouterMock.close();
        retryHandlerMock.close();
    }

    @Test
    void testDispatchWithExceptionInChannel() {
        NotificationChannel mockChannel = mock(NotificationChannel.class);
        doThrow(new RuntimeException("Test Exception")).when(mockChannel).sendNotification("EMAIL: Test Message");

        eventRouterMock.when(() -> EventRouter.routeEvent("EMAIL: Test Message"))
                .thenReturn(mockChannel);

        NotificationDispatcher.dispatch("EMAIL: Test Message");

        retryHandlerMock.verify(() -> RetryHandler.retryNotification("EMAIL: Test Message", mockChannel), times(1));
        eventRouterMock.close();
        retryHandlerMock.close();
    }
}
