package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingle {
    INSTANCE; /* здесь мы указываем перечисления. */
    private Item trSing;

    private TrackerSingle() {
        this.trSing = new Item();
        trSing.setId(0);
        trSing.setName("Name for id 0");
    }

    public String getName() {
        return trSing.getName();
    }

    /* Конструкторы и методы. */
    public static void main(String[] args) {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        System.out.println(tracker.getName());
    }
}
