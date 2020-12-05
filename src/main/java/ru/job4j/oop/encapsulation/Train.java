package ru.job4j.oop.encapsulation;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по железным рельсам.");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " со скоростью 120 км/ч.");
    }
}
