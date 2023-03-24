package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 70);
        Book[] books = new Book[4];
        books[0] = new Book("Война и мир", 800);
        books[1] = cleanCode;
        books[2] = new Book("none", 0);
        books[3] = new Book("Конёк-горбунок", 90);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getPages());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(cleanCode)) {
                System.out.println(books[i].getTitle() + " - " + books[i].getPages());
            }
        }
    }
}
