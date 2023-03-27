package ru.job4j.tracker;

import java.util.Scanner;

public class NewStartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ===");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("Добавленная заявка: " + item);
                }
                case 1 -> {
                    System.out.println("=== Show all items ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Хранилище не содержит заявок");
                    }
                }
                case 2 -> {
                    System.out.println("=== Edit item ===");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (tracker.replace(id, new Item(name))) {
                        System.out.println("Заявка успешно изменена");
                    } else {
                        System.out.println("Ошибка замены заявки");
                    }
                }
                case 3 -> {
                    System.out.println("=== Delete item ===");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Заявка успешно удалена");
                    } else {
                        System.out.println("Ошибка удаления заявки");
                    }
                }
                case 6 -> {
                    run = false;
                }
                default -> {
                    System.out.println("Выберите команду в меню");
                }
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new NewStartUI().init(scanner, tracker);
    }
}