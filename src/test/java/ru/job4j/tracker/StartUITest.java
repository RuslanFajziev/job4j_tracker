package ru.job4j.tracker;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.addItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item();
        expected.setName("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        String[] answers = {"replaced item", String.valueOf(item.getId())};
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        int idDel = item.getId();
        String[] answers = {String.valueOf(idDel)};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(idDel);
        assertThat(String.valueOf(replaced), is("null"));
    }

}