package ru.job4j.collection;

public class Task {
    final private String number;
    final private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}