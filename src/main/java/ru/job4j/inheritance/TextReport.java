package ru.job4j.inheritance;

public class TextReport {
    private String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
