package ru.job4j.checkstyle;

public class Broken {
    private String surname;

    private final int sizeOfEmpty = 10;

    private final String name = "1";

    private static String newValue = "";

    Broken() { }

    public static void echo() { }

    public static void method(int a, int b, int c, int d, int e) { }

    public static void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }
}