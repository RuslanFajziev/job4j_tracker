package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            System.out.println("-------------------------");
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            System.out.println(action.name());
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("-------------------------");
        System.out.println("         Menu");
        System.out.println("-------------------------");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddItem(),
                new ShowAll(),
                new EditItem(),
                new DeleteItem(),
                new FindItemName(),
                new FindItemId(),
                new ExitProgram(),
        };
        new StartUI().init(input, tracker, actions);
    }
}