package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixFlatMap {
    public static List<Integer> flatMap(Integer[][] array) {
        return Stream.of(array).flatMap(Arrays::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}