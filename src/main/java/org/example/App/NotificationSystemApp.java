package org.example.App;

import org.apache.log4j.BasicConfigurator;
import org.example.event.EventConsumer;
import org.example.event.EventProducer;


public class NotificationSystemApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        // Crear el consumidor y comenzar a escuchar eventos
        EventConsumer consumer = new EventConsumer();
        consumer.startListening();


        // Crear el productor y enviar algunos eventos
        EventProducer producer = new EventProducer();
        producer.sendEvent("EMAIL: Hello via Email!");
        producer.sendEvent("SMS: Hello via SMS!");
        producer.sendEvent("EMAIL: Another email notification!");
        producer.sendEvent("SMS: Another SMS notification!");

    }
}
