package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int i = 0;
        while (i < products.length) {
            if (products[i] == null) {
                break;
            }
            i++;
        }
        return ((i == products.length) ? -1 : i);
    }
}
