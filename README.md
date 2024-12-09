# Notification System Documentation

This system allows users to send email and SMS notifications using a simple console interface. Messages are processed and routed automatically based on the chosen notification type.

---

## **How to Use**
1. **Start the Application**:
   Run the application in your console. The system will show you a menu with three options:
   ```
   Select notification type:
   1. Send Email
   2. Send SMS
   3. Exit
   ```

2. **Select an Option**:
   - Type `1` to send an **Email Notification**.
   - Type `2` to send an **SMS Notification**.
   - Type `3` to **Exit** the system.

3. **Enter Your Message**:
   - After choosing an option, you will be asked to type your message.
   - The system will process the message and send it to the chosen channel.

4. **Check Confirmation**:
   - If the notification is sent successfully, you will see a confirmation message in the console.
   - If there is an error, the system will retry automatically.

5. **Exit the System**:
   - Type `3` when you are done to close the application.

---

## **Example**
**Scenario**: Sending an email notification.
1. Start the application.
2. Select `1` for "Send Email".
3. Input your message, e.g., "Meeting at 3 PM".
4. The system processes and sends the email.
5. See the message: `Message sent.`

---

## **System Workflow**
1. The **ConsoleUI** collects user input (notification type and message).
2. The message is sent to the **EventQueue**.
3. The **EventConsumer** processes the message and routes it using the **EventRouter**.
4. The **NotificationDispatcher** determines the correct notification channel (Email or SMS).
5. If sending fails, the **RetryHandler** retries up to three times.

---

## **Error Handling**
- If the system cannot send a notification after three retries, it logs the error and stops further attempts.

---

## **Requirements**
- Java runtime environment installed.
- Console or terminal access to run the application.

---

## **Developed By**
# Team members:
- Alex Paca Meneses
- Gabriela Garcia Villalobos
