package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> forNames = new ArrayList<>();
        int namesSize = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
                forNames.add(namesSize++, items.get(i));
            }
        }
        return forNames;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.remove(index);
            items.add(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            size--;
        }
        return rsl;
    }
}