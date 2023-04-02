package ru.job4j.cast;

public class VenicleMain {
    public static void main(String[] args) {
        Venicle train = new Train();
        Venicle bus = new Bus();
        Venicle plane = new Plane();
        Venicle[] venicles = new Venicle[] {train, bus, plane};
        for (Venicle v : venicles) {
            v.move();
        }
    }
}
