package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        Item item2 = new Item();
        tracker.add(item2);
        System.out.println(tracker.findById(1));
        System.out.println(tracker.findById(2));
    }
}