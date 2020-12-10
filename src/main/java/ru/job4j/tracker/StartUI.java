package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            out.println("-------------------------");
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            out.println(action.name());
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("-------------------------");
        out.println("         Menu");
        out.println("-------------------------");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
//                new AddItem(output),
//                new ShowAll(output),
//                new EditItem(output),
//                new DeleteItem(output),
//                new FindItemName(output),
//                new FindItemId(output),
                new ExitProgram(output),
        };
        new StartUI(output).init(input, tracker, actions);
    }
}