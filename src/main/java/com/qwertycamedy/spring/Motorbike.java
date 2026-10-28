package com.qwertycamedy.spring;

import org.springframework.stereotype.Component;

@Component("bike")
public class Motorbike implements Vehicle {
    @Override 
    public void startEngine() {
        System.out.println("Motorbike: ttttrrrrr!");
    }
}
