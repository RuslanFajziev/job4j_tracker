package ru.job4j.pojo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class proverka {
    public static void main(String[] args) {
//        int[] ar = {1, 2, 3};
//        int[] ar2 = Arrays.copyOf(ar, ar.length);
//        for (int i = 0; i < ar2.length; i++) {
//            System.out.println(ar[i]);
//        }
//
//        Product first = new Product("Milk", 100);
//        Product second = new Product("Milk", 100);
//        boolean eq = first == second;
//        System.out.println(eq);
//        eq = first.equals(second);
//        System.out.println(eq);
        int[] numbers = {167, -2, 16, 99, 26, 92, 43, -234, 35, 80};
        int[] numbersCopy = Arrays.copyOf(numbers, 4);
        System.out.println(Arrays.toString(numbersCopy));
        System.out.println(numbersCopy.length);

    }
}
