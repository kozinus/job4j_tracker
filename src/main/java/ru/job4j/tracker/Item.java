package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;

import ru.job4j.toone.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

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

    private LocalDateTime created = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participates = new ArrayList<>();

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.name);
    }
}