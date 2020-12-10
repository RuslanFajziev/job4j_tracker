package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String idItem = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", replacedName, idItem, "1"}
        );
        UserAction[] actions = {
                new EditItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Deleted item");
        tracker.add(item);
        String idItem = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", idItem, "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitProgram(out)};
        new StartUI(out).init(in, tracker, actions);
        String str = "-------------------------" + System.lineSeparator() + "         Menu";
        str += System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "0. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        assertThat(out.toString(), is(str));
    }
}