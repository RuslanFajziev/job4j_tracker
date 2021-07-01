package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private MemTracker tracker;

    private TrackerSingle3() {
        Item item = new Item();
        MemTracker track = new MemTracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingle3.getInstance().getTracker();
    }
}