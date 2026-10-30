package com.qwertycamedy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//синглтон, это когда экземпляр создается один раз и используется другими объектами
//в спринге этот паттерн бинов настраивается автоматически по дефолту или аннотацией @Scope("singleton")

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qwertycamedy.spring");
        // они у нас синглтоны
        Vehicle car1 = context.getBean("car", Vehicle.class);
        Vehicle car2 = context.getBean("car", Vehicle.class);

        // тоже синглтоны
        DBConnector connector1 = DBConnector.getInstance();
        DBConnector connector2 = DBConnector.getInstance();

        connector1.executeSql("user");
        connector2.executeSql("admin");

        System.out.println("connector1 == connector2: " + (connector1 == connector2));

        context.close();
    }
}
