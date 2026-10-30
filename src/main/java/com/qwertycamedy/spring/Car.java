package com.qwertycamedy.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("car")
@Scope("prototype")
public class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car: wrooommmmm!");
    }
}
