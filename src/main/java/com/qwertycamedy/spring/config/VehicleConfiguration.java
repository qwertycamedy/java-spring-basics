package com.qwertycamedy.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qwertycamedy.spring.Car;
import com.qwertycamedy.spring.Dog;
import com.qwertycamedy.spring.Motorbike;
import com.qwertycamedy.spring.Person;
import com.qwertycamedy.spring.Vehicle;

//с помощью аннотации configuration мы можем дать спрингу нужные бины, которые физически не можем менять
@Configuration
public class VehicleConfiguration {
    // для того, чтобы дать спрингу нужный бин, мы вызываем аннотацию bean над
    // методом, который отдает спрингу нужный компонет в виде возвращенного нового
    // класса
    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Motorbike bike() {
        return new Motorbike();
    }

    @Bean
    public Person person(@Qualifier("bike") Vehicle vehicle, Dog dog) {
        return new Person(vehicle, dog);
    }
}
