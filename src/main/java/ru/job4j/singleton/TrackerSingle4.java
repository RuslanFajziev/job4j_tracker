package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingle4 {
    private MemTracker tracker;

    private TrackerSingle4() {
        Item item = new Item();
        MemTracker track = new MemTracker();
        item.setName("Name Singleton");
        track.add(item);
        this.tracker = track;
    }

    public MemTracker getTracker() {
        return tracker;
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingle4.getInstance().getTracker();
    }
}
