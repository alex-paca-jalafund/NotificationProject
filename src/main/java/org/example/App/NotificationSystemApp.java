package org.example.App;

import org.example.event.EventConsumer;
import org.example.event.EventProducer;

import java.util.Scanner;

public class NotificationSystemApp {

    public static void main(String[] args) {
        EventProducer producer = new EventProducer();
        EventConsumer consumer = new EventConsumer();

        // Iniciar el consumidor en un hilo separado
        Thread consumerThread = new Thread(consumer::startListening);
        consumerThread.start();

        System.out.println("🎉 Sistema de Notificaciones Asíncronas");
        System.out.println("Escribe un mensaje para enviarlo como evento. Escribe 'salir' para terminar.");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("📥 Ingresa tu mensaje: ");
                String input = scanner.nextLine();

                if ("salir".equalsIgnoreCase(input)) {
                    System.out.println("👋 Finalizando el sistema.");
                    break;
                }

                producer.sendEvent(input);
            }
        }
    }
}
