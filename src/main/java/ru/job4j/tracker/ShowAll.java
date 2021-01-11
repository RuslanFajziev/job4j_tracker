package ru.job4j.tracker;

import java.util.List;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> item = tracker.findAll();
        for (Item arr : item) {
            out.println(arr);
        }
        return true;
    }
}
