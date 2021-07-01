package ru.job4j.tracker;

public class AddItem implements UserAction {
    private final Output out;

    public AddItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Add new Item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        return true;
    }
}
