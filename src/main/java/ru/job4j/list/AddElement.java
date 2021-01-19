package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
    public static boolean addNewElement(List<String> list, String str) {
        List<String> check = new ArrayList<>(list);
        int strSize = check.size();
        check.add(str);
        int fnSize = check.size();
        return fnSize > strSize;
    }
}