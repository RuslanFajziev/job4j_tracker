package ru.job4j.tracker;

public class FindItemId implements UserAction {
    private final Output out;

    public FindItemId(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        Item findId = tracker.findById(id);
        if (findId != null) {
            out.println(findId);
        } else {
            out.println("== Find by Id ERROR!!!!! ==");
        }
        return true;
    }
}
