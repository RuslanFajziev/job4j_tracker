package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id: ");
        Item newItem = new Item();
        newItem.setName(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("successful replacement");
        } else {
            System.out.println("== replacement ERROR!!!!! ==");
        }
        return true;
    }
}
