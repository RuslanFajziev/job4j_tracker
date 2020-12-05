package ru.job4j.oop.encapsulation;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " со скоростью 950 км/ч.");
    }

}
