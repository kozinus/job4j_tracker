package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1split = o1.split("/", 2);
        String[] o2split = o2.split("/", 2);
        int rsl = o2split[0].compareTo(o1split[0]);
        if (rsl == 0) {
            rsl = Integer.compare(o1split.length, o2split.length);
            if (rsl == 0) {
                rsl = o1split[1].compareTo(o2split[1]);
            }
        }
        return rsl;
    }
}
