package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> rsl = indexOf(data, el);
        if (rsl.isPresent()) {
            return rsl.get();
        }
        return -1;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> rsl = Optional.empty();
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rsl = Optional.of(index);
                break;
            }
        }
        return rsl;
    }
}