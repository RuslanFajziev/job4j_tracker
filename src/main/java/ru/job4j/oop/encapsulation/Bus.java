package ru.job4j.oop.encapsulation;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по твердому грунту.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " со скоростью 100 км/ч.");
    }
}
