package com.qwertycamedy.spring;

import org.springframework.stereotype.Component;

@Component("cat")
public class Cat {
    public Cat() {
        System.out.println("Cat was created!");
    }

    public String getName() {
        return "Myaka";
    }
}
