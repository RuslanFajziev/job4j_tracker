package ru.job4j.oop;

public class Student {
    public void music() {
        System.out.println("Tra tra tra");
    }

    public void soung() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.soung();
        petya.soung();
        petya.soung();
    }
}
