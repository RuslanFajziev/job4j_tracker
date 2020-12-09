package ru.job4j.tracker;

public class FindItemName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] names = tracker.findByName(name);
        if (names.length != 0) {
            for (Item findName : names) {
                System.out.println(findName);
            }
        } else {
            System.out.println("== Find by name ERROR!!!!! ==");
        }
        return true;
    }
}
