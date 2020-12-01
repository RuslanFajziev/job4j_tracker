package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemDate {
    private int id;
    private String name;
    private LocalDateTime created;

    public ItemDate() {
    }

    public ItemDate(String name) {
        this.name = name;
    }

    public ItemDate(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public static void main(String[] args) {
        ItemDate item = new ItemDate();
        ItemDate itemName = new ItemDate("Vasay");
        ItemDate itemIdName = new ItemDate(45, "Petay");
    }

    public String getCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = created.format(formatter);
        return currentDateTimeFormat;
    }
}