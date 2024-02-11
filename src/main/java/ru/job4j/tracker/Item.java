package ru.job4j.tracker;

import lombok.Data;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Data
public class Item implements Comparable<Item> {
    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.created = created;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER) + '\''
                + '}';
    }

    @Override
    public int compareTo(Item another) {
        return this.name.compareTo(another.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item item)) {
            return false;
        }
        return getId() == item.getId() && getCreated().equals(item.getCreated()) && getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreated(), getId(), getName());
    }
}