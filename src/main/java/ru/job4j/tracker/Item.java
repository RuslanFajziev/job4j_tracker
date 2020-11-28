package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item itemName = new Item("Vasay");
        Item itemIdName = new Item(45, "Petay");
    }

    public String getCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = created.format(formatter);
        return currentDateTimeFormat;
    }
}