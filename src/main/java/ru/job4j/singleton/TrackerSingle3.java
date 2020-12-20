package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private Item trSing;

    private TrackerSingle3() {
        this.trSing = new Item();
        trSing.setId(0);
        trSing.setName("Name for id 0");
    }

    public String getName() {
        return trSing.getName();
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
        System.out.println(tracker.getName());
    }
}