package ru.job4j.tracker;

public class FindItemId implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item findId = tracker.findById(id);
        if (findId != null) {
            System.out.println(findId);
        } else {
            System.out.println("== Find by Id ERROR!!!!! ==");
        }
        return true;
    }
}
