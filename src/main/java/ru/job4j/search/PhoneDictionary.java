package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> containsSurname = person -> person.getSurname().contains(key);
        Predicate<Person> containsName = person -> person.getName().contains(key);
        Predicate<Person> containsAddress = person -> person.getAddress().contains(key);
        Predicate<Person> containsPhone = person -> person.getPhone().contains(key);
        Predicate<Person> predicate = containsAddress.or(containsPhone)
                .or(containsName).or(containsSurname);
        Consumer<Person> consumer = person -> {
            if (predicate.test(person)) {
                result.add(person);
            }
        };
        persons.forEach(consumer);
        return result;
    }
}
