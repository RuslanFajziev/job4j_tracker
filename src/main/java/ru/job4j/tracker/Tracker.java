package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        for (int index = 0; index < size; index++) {
            if (items[index] == null) {
                size = index;
                break;
            }
        }
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[items.length];
        int counter = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                tmp[counter++] = items[index];
            }
        }
        return Arrays.copyOf(tmp, counter);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item itemRep) {
        int index = indexOf(id);
        boolean result = false;
        if (index != -1) {
            items[index].setName(itemRep.getName());
            result = true;
        }
        return result;
    }
}