package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        int start = list.indexOf(str);
        int end = list.lastIndexOf(str);
        boolean rsl = false;
        if ((start == end && end > -1) || (start != end && (start == -1 || end == -1))) {
            rsl = true;
        }
        return rsl;
    }
}