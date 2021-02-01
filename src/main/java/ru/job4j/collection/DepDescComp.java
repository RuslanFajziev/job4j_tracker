package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(o1.split("/")));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList(o2.split("/")));
        int rsl = 0;
        int arr1Sz = arr1.size();
        int arr2Sz = arr2.size();

        int diff = Integer.compare(arr1Sz, arr2Sz);
        if (diff != rsl) {
            rsl = diff;
        }
        int lnIndex = Math.min(arr1Sz, arr2Sz);

        for (int index = 0; index < lnIndex; index++) {
            int rslTmp = arr1.get(index).compareTo(arr2.get(index));
            if (rslTmp != 0) {
                rsl = rslTmp;
                break;
            }
        }
        return rsl;
    }
}