package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private Item trSing;

    private TrackerSingle2() {
        this.trSing = new Item();
        trSing.setId(0);
        trSing.setName("Name for id 0");
    }

    public String getName() {
        return trSing.getName();
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public static void main(String[] args) {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
        System.out.println(tracker.getName());
    }
}