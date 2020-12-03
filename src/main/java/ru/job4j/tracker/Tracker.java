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

    public Boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result && size != 1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        } else if (size == 1) {
            items[0] = null;
            size--;
        }
        return result;
    }

    public Item[] findAll() {
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
        boolean result = index != -1;
        if (result) {
            itemRep.setId(id);
            items[index] = itemRep;
        }
        return result;
    }
}