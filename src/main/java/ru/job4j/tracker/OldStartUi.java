package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class OldStartUi {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateFormat = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateFormat);

        Item itemSecond = new Item("named");
        System.out.println(itemSecond);
    }
}
