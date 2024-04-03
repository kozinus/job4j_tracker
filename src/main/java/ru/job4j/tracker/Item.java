package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    private LocalDateTime created = LocalDateTime.now().withSecond(0).withNano(0);

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.name);
    }
}