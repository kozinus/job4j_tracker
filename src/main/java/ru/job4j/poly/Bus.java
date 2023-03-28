package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void ride() {
        System.out.println("Start driving");
    }

    @Override
    public void passengers(int val) {
        System.out.println(val + " passengers in bus");
    }

    @Override
    public int refill(int fuel) {
        return fuel * 56;
    }
}
