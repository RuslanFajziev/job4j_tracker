package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixFlatMap {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        System.out.println(matrix.stream().flatMap(List::stream).collect(Collectors.toList()));
    }
}
