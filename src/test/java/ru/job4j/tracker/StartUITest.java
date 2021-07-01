package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new AddItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Store tracker = new MemTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String idItem = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", replacedName, idItem, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Store tracker = new MemTracker();
        Item item = new Item();
        item.setName("Deleted item");
        tracker.add(item);
        String idItem = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", idItem, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String str = "-------------------------" + System.lineSeparator() + "         Menu";
        str += System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "0. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        assertThat(out.toString(), is(str));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAll(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String str = "-------------------------" + System.lineSeparator() + "         Menu" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "0. === Show all items ===" + System.lineSeparator();
        str += "1. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Show all items ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "         Menu" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "0. === Show all items ===" + System.lineSeparator() + "1. === Exit Program ===" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "=== Exit Program ===" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator();
        assertThat(out.toString(), is(str));
    }

    @Test
    public void whenFindItemName() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Name Find", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemName(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String str = "-------------------------" + System.lineSeparator() + "         Menu" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "0. === Find items by name ===" + System.lineSeparator();
        str += "1. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Find items by name ===" + System.lineSeparator() + "== Find by name ERROR!!!!! ==" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "         Menu" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "0. === Find items by name ===" + System.lineSeparator();
        str += "1. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        assertThat(out.toString(), is(str));
    }

    @Test
    public void whenFindItemId() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1", "1"});
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemId(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String str = "-------------------------" + System.lineSeparator() + "         Menu" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "0. === Find item by Id ===" + System.lineSeparator();
        str += "1. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Find item by Id ===" + System.lineSeparator() + "== Find by Id ERROR!!!!! ==" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "         Menu" + System.lineSeparator();
        str += "-------------------------" + System.lineSeparator() + "0. === Find item by Id ===" + System.lineSeparator();
        str += "1. === Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        str += "=== Exit Program ===" + System.lineSeparator() + "-------------------------" + System.lineSeparator();
        assertThat(out.toString(), is(str));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "-------------------------%n"
                        + "         Menu%n"
                        + "-------------------------%n"
                        + "0. === Exit Program ===%n"
                        + "-------------------------%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "-------------------------%n"
                        + "         Menu%n"
                        + "-------------------------%n"
                        + "0. === Exit Program ===%n"
                        + "-------------------------%n"
                        + "=== Exit Program ===%n"
                        + "-------------------------%n"
                )
        ));
    }
}