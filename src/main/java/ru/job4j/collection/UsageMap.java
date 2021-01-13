package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pupkin@mail.ru", "Pupkin Ivan");
        map.put("pupkin@mail.ru", "Pupkin Ivan Petrovich");
        map.put("map@mail.ru", "Map Hashevich Stringov");
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

    }
}
