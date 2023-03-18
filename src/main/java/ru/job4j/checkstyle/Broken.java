package ru.job4j.checkstyle;

public class Broken {

    private final int sizeOfEmpty = 10;
    public String surname;
    public static String name = "1";

    public static void method(int a, int b, int c, int d, int e) { }

    void echo() { }

    public static String newValue = "";

    public static void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    Broken() { }
}