package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStream {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        arrInt.add(1);
        arrInt.add(2);
        arrInt.add(3);
        arrInt.add(0);
        arrInt.add(-1);
        arrInt.add(-2);
        arrInt.add(4);
        arrInt.add(5);
        List<Integer> arrIntPosit = arrInt.stream().filter(x -> x > 0).collect(Collectors.toList());
        arrIntPosit.forEach(System.out::println);
    }

}
