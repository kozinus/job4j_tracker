package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        List<String> leftNumerals = new ArrayList<>(List.of(left.split("\\.")));
        List<String> rightNumerals = new ArrayList<>(List.of(right.split("\\.")));
        leftNumerals.remove(leftNumerals.size() - 1);
        rightNumerals.remove(rightNumerals.size() - 1);
        for (int i = 0;
             i < Integer.min(rightNumerals.size(), leftNumerals.size());
             i++) {
            int rsl = Integer.compare(Integer.parseInt(leftNumerals.get(i)),
                    Integer.parseInt(rightNumerals.get(i)));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(leftNumerals.size(), rightNumerals.size());
    }
}