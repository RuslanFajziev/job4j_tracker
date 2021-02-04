package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        HashSet<String> txt = new HashSet<>();
        Collections.addAll(txt, origin.split("[,;!.]| "));

        for (String checkTxt : line.split("[,;!.]| ")) {
            rsl = txt.contains(checkTxt);
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }
}