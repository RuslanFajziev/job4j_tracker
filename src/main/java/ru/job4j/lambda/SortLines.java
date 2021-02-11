package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Abc", "Abcd", "Abcdef");
        Comparator<String> cmpr = (left, right) -> {
            System.out.println("compareTo - " + left + " : " + right);
            return left.compareTo(right);
        };

        Comparator<String> cmpr2 = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        lst.sort(cmpr);
        System.out.println(lst);
        lst.sort(cmpr2);
        System.out.println(lst);
    }
}
