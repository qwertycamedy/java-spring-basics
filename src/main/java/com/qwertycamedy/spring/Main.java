package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Если scope нашего бина prototype, то destroy нужно делать вручную, а если singleton, то все делается автоматом

//Хорошая практика делать метод инита и дестроя так, как сделано в car, а именно private void без аргументов (если впихнуть аргументы, то код и вовсе сломается)

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qwertycamedy.spring");
        Vehicle car = context.getBean("car", Vehicle.class);

        car.startEngine();

        context.close();
        System.out.println("program is finished!");
    }
}
