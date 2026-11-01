package com.qwertycamedy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qwertycamedy.spring.Dog;

@Configuration 
public class PetConfiguration {
    @Bean 
    public Dog dog() {
        return new Dog();
    }
}
