package ru.job4j.pojo;

import java.util.Arrays;

public class ShopDrop {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        System.out.println();
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    public static Product[] leftShift(Product[] products, int index) {
        Product[] newArray = Arrays.copyOf(products, products.length);
        for (int i = index; i < products.length; i++) {
            if (i + 1 >= products.length) {
                newArray[i] = null;
            } else {
                newArray[i] = products[i + 1];
            }
        }
        return newArray;
    }
}
