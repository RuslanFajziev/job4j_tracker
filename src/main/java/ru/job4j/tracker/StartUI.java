package ru.job4j.tracker;

import java.time.LocalDateTime;

public class StartUI {
//    Item item = new Item(5, "Petr");
    public static void main(String[] args) {
        Item item = new Item(5, "Petr");
         String time = item.getCreated();
        System.out.println(time);
    }
}
