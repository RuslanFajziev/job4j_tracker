package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle4 {
    private Item trSing;

    private TrackerSingle4() {
        this.trSing = new Item();
        trSing.setId(0);
        trSing.setName("Name for id 0");
    }

    public String getName() {
        return trSing.getName();
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public static void main(String[] args) {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
        System.out.println(tracker.getName());
    }
}
