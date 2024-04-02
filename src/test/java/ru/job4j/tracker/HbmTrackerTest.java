package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {

    @BeforeEach
    public void wipeAll() {
        try (var tracker = new HbmTracker()) {
            tracker.wipeTable();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
         try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddNewItemThenUpdateSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            item.setName("test2");
            assertThat(tracker.replace(item.getId(), item)).isTrue();
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddNewItemThenDeleteIt() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            assertThat(tracker.delete(item.getId())).isTrue();
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    public void whenAddNewItemsThenTrackerHasSameItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            List<Item> items = Arrays.asList(new Item("test1"), new Item("test2"), new Item("test2"));
            items.forEach(tracker::add);
            List<Item> trackerItems = tracker.findAll();
            assertThat(trackerItems.subList(trackerItems.size() - items.size(), trackerItems.size())).isEqualTo(items);
        }
    }

    @Test
    public void whenAddNewItemsThenTrackerFindsSameItemsByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            List<Item> items = Arrays.asList(new Item("name1"), new Item("name2"),
                    new Item("name1"), new Item("Name3"), new Item("name1"));
            items.forEach(tracker::add);
            List<Item> trackerItems = tracker.findByName("name1");
            assertThat(trackerItems).isEqualTo(items.stream().filter(x -> x.getName().equals("name1")).toList());
        }
    }

    @Test
    public void whenAddNewItemsThenTrackerFindsOneItemById() throws Exception {
        try (var tracker = new HbmTracker()) {
            List<Item> items = Arrays.asList(new Item("name1"), new Item("name2"),
                    new Item("name1"), new Item("Name3"), new Item("name1"));
            items.forEach(tracker::add);
            Item result = tracker.findById(items.get(3).getId());
            assertThat(result).isEqualTo(items.get(3));
        }
    }
}