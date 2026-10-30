package com.qwertycamedy.spring;

import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car: wrooommmmm!");
    }
}
