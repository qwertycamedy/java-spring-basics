package com.qwertycamedy.spring;

import com.qwertycamedy.spring.config.ApplicationConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class);
        DatabaseConnector dbConnector = context.getBean("dbConnector", DatabaseConnector.class);

        dbConnector.executeSql("SELECT * FROM students");

        context.close();
    }
}
