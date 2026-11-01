package com.qwertycamedy.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Car implements Vehicle {
    @PostConstruct 
    private void init() {
        System.out.println("Car init method is called!");
    }

    @Override
    public void startEngine() {
        System.out.println("Car: wrooommmmm!");
    }
    
    @PreDestroy 
    private void destroy() {
        System.out.println("Car destroy method is called!");
    }
}
