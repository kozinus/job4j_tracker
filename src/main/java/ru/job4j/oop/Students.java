package ru.job4j.oop;

public class Students {
    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sing() {
        System.out.println("I believe i can fly");
    }

    public static void main(String[] args) {
        Students petya = new Students();
        petya.music();
        petya.sing();
        petya.music();
        petya.sing();
        petya.music();
        petya.sing();
    }
}
