package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public enum TrackerSingle {
    INSTANCE;
    private MemTracker tracker;

    private TrackerSingle() {
        Item item = new Item();
        MemTracker track = new MemTracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
     }

    public MemTracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        MemTracker trackerS = TrackerSingle.INSTANCE.getTracker();
    }
}
