package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int index = 0;
        while (items[index] != null) {
            index++;
        }
        return Arrays.copyOf(items, index + 1);
    }

    public Item[] findByName(String key) {
        Item[] forNames = new Item[100];
        int namesSize = 0;
        for (int i = 0; i < items.length && items[i] != null; i++) {
            if (items[i].getName().equals(key)) {
                forNames[namesSize] = items[i];
                namesSize++;
            }
        }
        return Arrays.copyOf(forNames, namesSize);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = new Item(items[index].getId(), item.getName());
            return true;
        }
        return false;
    }
}