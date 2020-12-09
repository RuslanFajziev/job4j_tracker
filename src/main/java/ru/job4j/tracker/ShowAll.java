package ru.job4j.tracker;

public class ShowAll implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] array = tracker.findAll();
        for (Item arr : array) {
            System.out.println(arr);
        }
        return true;
    }
}
