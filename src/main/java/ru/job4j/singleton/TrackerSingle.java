package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerSingle {
    INSTANCE;
    private Tracker tracker;

    private TrackerSingle() {
        Item item = new Item();
        Tracker track = new Tracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
     }

    public Tracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Tracker trackerS = TrackerSingle.INSTANCE.getTracker();
    }
}
