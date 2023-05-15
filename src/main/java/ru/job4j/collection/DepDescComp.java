package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1split = o1.split("/", 2);
        String[] o2split = o2.split("/", 2);
        int rsl = o2split[0].compareTo(o1split[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}
