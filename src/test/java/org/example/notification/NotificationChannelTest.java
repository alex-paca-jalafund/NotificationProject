package org.example.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class NotificationChannelTest {

    private EmailNotificationChannel emailChannel;
    private SmsNotificationChannel smsChannel;

    @BeforeEach
    void setUp() {
        emailChannel = mock(EmailNotificationChannel.class);
        smsChannel = mock(SmsNotificationChannel.class);
    }

    @Test
    void testSendEmailNotification() {
        emailChannel.sendNotification("Test email message");
        verify(emailChannel, times(1)).sendNotification("Test email message");
    }

    @Test
    void testSendSmsNotification() {
        smsChannel.sendNotification("Test SMS message");
        verify(smsChannel, times(1)).sendNotification("Test SMS message");
    }

    @Test
    void testSendEmailNotificationTwice() {
        emailChannel.sendNotification("Test email message");
        emailChannel.sendNotification("Test email message again");
        verify(emailChannel, times(2)).sendNotification(anyString());
    }

    @Test
    void testSendSmsNotificationTwice() {
        smsChannel.sendNotification("Test SMS message");
        smsChannel.sendNotification("Test another SMS message");
        verify(smsChannel, times(2)).sendNotification(anyString());
    }

    @Test
    void testEmailNotificationNotCalled() {
        verify(emailChannel, never()).sendNotification(anyString());
    }

    @Test
    void testSmsNotificationNotCalled() {
        verify(smsChannel, never()).sendNotification(anyString());
    }
}
