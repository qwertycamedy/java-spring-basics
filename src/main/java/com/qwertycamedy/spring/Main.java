package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//prototype, это когда экземпляр создается каждый раз при вызове бина
//в спринге этот паттерн бинов настраивается аннотацией @Scope("prototype")

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qwertycamedy.spring");
        // они у нас prototype и создаются только когда мы сами их создаем и создаются каждый раз новые прототипы
        Vehicle car1 = context.getBean("car", Vehicle.class);
        Vehicle car2 = context.getBean("car", Vehicle.class);
        //наши автоматические синглтоны, которые создались когда мы создали контекст и сейчас мы в наших объектах только вызываем один экземпляр
        Vehicle bike1 = context.getBean("bike", Vehicle.class);
        Vehicle bike2 = context.getBean("bike", Vehicle.class);

        System.out.println("car1 == car2: " + (car1 == car2));
        System.out.println("bike1 == bike2: " + (bike1 == bike2));

        context.close();
    }
}
