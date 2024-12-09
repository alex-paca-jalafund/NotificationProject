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
The **Asynchronous Event-Driven Notification System** is a modular architecture designed to process and send notifications efficiently using asynchronous events. Here's a breakdown of its key components:  

1. **User**: Triggers notifications by generating events.  
2. **Event Producer**: Creates events and sends them to the **Event Queue**.  
3. **Event Queue**: Temporarily stores events until they are processed.  
4. **Event Consumer**: Retrieves events from the queue and passes them for routing.  
5. **Event Router**: Determines the appropriate notification channel (Email or SMS).  
6. **Notification Dispatcher**: Sends notifications through the corresponding channels:
   - **Email Sender**: Sends email notifications.  
   - **SMS Sender**: Sends SMS notifications.  
7. **Retry Mechanism**: Handles failed notification attempts, retrying them up to a set limit.  

**Flow**:  
User → Event Producer → Event Queue → Event Consumer → Event Router → Notification Dispatcher → Retry Mechanism  

The system ensures scalability, asynchronous processing, and reliable delivery of notifications.


1. SystemContext: System view, includes all the elements and their interactions in the notification system.

![image](https://github.com/user-attachments/assets/fff1195d-1938-48b9-9723-49b98acb412d)


2. ContainerView: Container View, shows the system containers (Event Producer, Event Queue, Event Consumer, Event Router, Notification Dispatcher, Retry Mechanism) and their relationships.

![image](https://github.com/user-attachments/assets/1330ec7e-0ee7-4873-aca1-cc4f81e478f6)

![image](https://github.com/user-attachments/assets/f1186200-1cae-4783-b237-bd5be1fe57d6)

3. NotificationDispatcherComponents: View of the Notification Dispatcher components, showing the Email Sender and the SMS Sender, with their relationship between them for sending notifications.

![image](https://github.com/user-attachments/assets/0a8d7d33-2795-4ce6-9a64-02719150177a)


---

## **Developed By**
# Team members:
- Alex Paca Meneses
- Gabriela Garcia Villalobos

## **Tools**

- [Notification System Design on Canva](https://www.canva.com/design/DAGWdWh4MdY/_3TRRx6CJ9IWf09lc0gJ9w/edit?utm_content=DAGWdWh4MdY&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
- [Notification Project Board on Trello](https://trello.com/invite/b/672259a93c5119e2dcd0f37b/ATTI6eb6f4d3e12cd9d0888bdd48f3bc00267DE8E947/notification-project)
