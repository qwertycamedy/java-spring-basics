package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qwertycamedy.spring");
        Vehicle vehicle = context.getBean("bike", Vehicle.class);

        vehicle.startEngine();

        context.close();
    }
}
