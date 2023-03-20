package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        first.printInfo();
        Error second = new Error(true, 12, "Yes");
        second.printInfo();
        Error third = new Error(false, 9, "Lu-la-lei-lo");
        third.printInfo();
    }
}
