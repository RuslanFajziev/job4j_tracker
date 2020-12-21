package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle4 {
    private Tracker tracker;

    private TrackerSingle4() {
        Item item = new Item();
        Tracker track = new Tracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle4.getInstance().getTracker();
    }
}
