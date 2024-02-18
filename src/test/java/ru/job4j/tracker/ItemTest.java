package ru.job4j.tracker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@Disabled
class ItemTest {
    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item("Ape"),
                new Item("Whale"),
                new Item("Gus"),
                new Item("Lion")
        );
        List<Item> expected = new java.util.ArrayList<>(List.copyOf(items));
        Collections.sort(expected);
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item("Ape"),
                new Item("Whale"),
                new Item("Gus"),
                new Item("Lion")
        );
        List<Item> expected = new java.util.ArrayList<>(List.copyOf(items));
        Collections.sort(expected, Collections.reverseOrder());
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}