package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private Tracker tracker;

    private TrackerSingle2() {
        Item item = new Item();
        Tracker track = new Tracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle2.getInstance().getTracker();
    }
}