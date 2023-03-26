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
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}