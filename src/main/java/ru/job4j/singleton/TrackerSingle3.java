package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private Tracker tracker;

    private TrackerSingle3() {
        Item item = new Item();
        Tracker track = new Tracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle3.getInstance().getTracker();
    }
}