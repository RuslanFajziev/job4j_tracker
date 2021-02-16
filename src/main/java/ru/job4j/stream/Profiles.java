package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        Comparator<Address> cmp = (x, y) -> x.getCity().compareTo(y.getCity());
        return profiles.stream()
                .map(x -> x.getAddress())
                .sorted(cmp)
                .distinct()
                .collect(Collectors.toList());
    }
}