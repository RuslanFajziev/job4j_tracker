package ru.job4j.tracker;

import java.util.List;

public class FindItemName implements UserAction {
    private final Output out;

    public FindItemName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> names = tracker.findByName(name);
        if (names.size() != 0) {
            for (Item findName : names) {
                out.println(findName);
            }
        } else {
            out.println("== Find by name ERROR!!!!! ==");
        }
        return true;
    }
}
