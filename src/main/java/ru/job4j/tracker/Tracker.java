package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Boolean delete(int id) {
        boolean result = false;
        Item rstItem = findById(id);
        if (rstItem != null) {
            items.remove(rstItem);
            result = true;
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> tmp = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                tmp.add(item);
            }
        }
        return tmp;
    }

    public Item findById(int id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item itemRep) {
        boolean result = false;
        Item rstItem = findById(id);
        if (rstItem != null) {
            for (int index = 0; index < items.size(); index++) {
                if (items.get(index).getId() == id) {
                    items.remove(index);
                    itemRep.setId(id);
                    items.add(index, itemRep);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}