package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private MemTracker tracker;

    private TrackerSingle2() {
        Item item = new Item();
        MemTracker track = new MemTracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingle2.getInstance().getTracker();
    }
}