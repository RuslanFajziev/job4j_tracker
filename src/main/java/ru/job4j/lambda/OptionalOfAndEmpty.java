package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optS = Optional.empty();
        for (var str : strings) {
            if (str.equals(value)) {
                optS = Optional.of(str);
                break;
            }
        }
        return optS;
    }
}