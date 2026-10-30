package com.qwertycamedy.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("bike")
public class Motorbike implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorbike: ttttrrrrr!");
    }
}
