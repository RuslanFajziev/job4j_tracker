package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(o1.split("/")));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList(o2.split("/")));
        int rsl = arr2.get(0).compareTo(arr1.get(0));
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}