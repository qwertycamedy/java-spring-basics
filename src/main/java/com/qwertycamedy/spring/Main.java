package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qwertycamedy.spring.config.ApplicationConfiguration;

//Если scope нашего бина prototype, то destroy нужно делать вручную, а если singleton, то все делается автоматом

//Хорошая практика делать метод инита и дестроя так, как сделано в car, а именно private void без аргументов (если впихнуть аргументы, то код и вовсе сломается)

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class);
        Person person = context.getBean("person", Person.class);

        person.driveVehicle();
        person.comeDog();

        context.close();
        System.out.println("program is finished!");
    }
}
