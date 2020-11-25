package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNike(String nike) {
        this.name = nike;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println("There are " + this.name + " food: " + this.food);
        System.out.println();
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNike("gav's");
        gav.show();
        Cat black = new Cat();
        gav.eat("fish");
        gav.giveNike("black's");
        gav.show();
    }
}
