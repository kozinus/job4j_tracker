package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer customer = null;
        for (int index = 0; index < count; index++) {
            customer = queue.poll();
        }
        if (customer == null) {
            return null;
        }
        return customer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer customer = null;
        for (int index = 0; index < count + 1; index++) {
            customer = queue.poll();
        }
        if (customer == null) {
            return null;
        }
        return customer.name();
    }
}
