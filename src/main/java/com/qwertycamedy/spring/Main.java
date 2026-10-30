package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qwertycamedy");
        Person person = context.getBean("person", Person.class);
        Parking parking = context.getBean("parking", Parking.class);

        System.out.println(parking.getList());
        System.out.println(parking.getMap());

        person.driveVehicle();

        context.close();
    }
}
