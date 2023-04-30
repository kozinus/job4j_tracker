package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        List<String> leftNumerals =
                Arrays.stream((left.split(" "))[0].split("\\.")).toList();
        List<String> rightNumerals =
                Arrays.stream((right.split(" "))[0].split("\\.")).toList();
        for (int i = 0;
             i < Integer.min(rightNumerals.size(), leftNumerals.size());
             i++) {
            rsl = Integer.compare(Integer.parseInt(leftNumerals.get(i)),
                    Integer.parseInt(rightNumerals.get(i)));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(leftNumerals.size(), rightNumerals.size());
    }
}