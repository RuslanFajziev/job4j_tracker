package ru.job4j.tracker;

public class StartUI {
    public static void addItem(Input input, Tracker tracker) {
        System.out.println("=== Add new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] array = tracker.findAll();
        for (Item arr : array) {
            System.out.println(arr);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id: ");
        Item newItem = new Item();
        newItem.setName(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("successful replacement");
        } else {
            System.out.println("== replacement ERROR!!!!! ==");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("== Delete ERROR!!!!! ==");
        }
    }

    public static void findItemId(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter id: ");
        Item findId = tracker.findById(id);
        if (findId != null) {
            System.out.println(findId);
        } else {
            System.out.println("== Find by Id ERROR!!!!! ==");
        }
    }

    public static void findItemName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] names = tracker.findByName(name);
        if (names.length != 0) {
            for (Item findName : names) {
                System.out.println(findName);
            }
        } else {
            System.out.println("== Find by name ERROR!!!!! ==");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.addItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("-------------------------");
        System.out.println("         Menu");
        System.out.println("-------------------------");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}