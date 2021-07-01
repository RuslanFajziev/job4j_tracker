package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            out.println("-------------------------");
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            out.println(action.name());
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("-------------------------");
        out.println("         Menu");
        out.println("-------------------------");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new AddItem(output),
                    new ShowAll(output),
                    new EditItem(output),
                    new DeleteItem(output),
                    new FindItemName(output),
                    new FindItemId(output),
                    new ExitProgram(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Output output = new ConsoleOutput();
//        Input input = new ValidateInput(output, new ConsoleInput());
//        Store tracker = new MemTracker();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new AddItem(output));
//        actions.add(new ShowAll(output));
//        actions.add(new EditItem(output));
//        actions.add(new DeleteItem(output));
//        actions.add(new FindItemName(output));
//        actions.add(new FindItemId(output));
//        actions.add(new ExitProgram(output));
//        new StartUI(output).init(input, tracker, actions);
    }
}