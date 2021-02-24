package ru.job4j.lambda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<Optional<String>> tmp = Optional.ofNullable(strings.stream()
                .filter(Objects::nonNull)
                .filter(x -> x.equals(value))
                .findFirst());
        if (tmp.isPresent()) {
            return tmp.get();
        } else {
            return Optional.empty();
        }
    }
}