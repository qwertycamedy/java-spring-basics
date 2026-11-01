package com.qwertycamedy.spring;

public class Person {
    private Vehicle vehicle;
    private Dog dog;

    public Person(Vehicle vehicle, Dog dog) {
        this.vehicle = vehicle;
        this.dog = dog;
    }

    public void driveVehicle() {
        System.out.println("person drive car!");
        this.vehicle.startEngine();
    }

    public void comeDog() {
        System.out.println(dog.getName() + " come to me!");
    }
}
