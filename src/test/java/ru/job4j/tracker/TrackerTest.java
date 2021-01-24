package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void addNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        bugWithDesc.setId(id);
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete2() {
        Tracker tracker = new Tracker();
        Item petr = new Item();
        petr.setName("Petr");
        tracker.add(petr);
        Item vasay = new Item();
        vasay.setName("Vasay");
        tracker.add(vasay);
        Item feday = new Item();
        feday.setName("Feday");
        tracker.add(feday);
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = vasay.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}