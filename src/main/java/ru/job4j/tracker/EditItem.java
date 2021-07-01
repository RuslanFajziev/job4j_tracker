package ru.job4j.tracker;

public class EditItem implements UserAction {
    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id: ");
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setId(id);
        if (tracker.replace(id, newItem)) {
            out.println("successful replacement");
        } else {
            out.println("== replacement ERROR!!!!! ==");
        }
        return true;
    }
}
