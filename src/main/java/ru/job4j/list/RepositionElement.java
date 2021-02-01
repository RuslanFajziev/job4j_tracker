package ru.job4j.list;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        int sizeL = list.size() -1;
        String value = list.remove(sizeL);
        if (index <= sizeL) {
            list.set(index, value);
        }
        return list;
    }
}