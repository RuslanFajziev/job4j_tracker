package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional<Integer> rsl = max(data);
        if (rsl.isPresent()) {
            System.out.println("Max: " + rsl.get());
        }
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> rsl = Optional.empty();
        if (data.length == 1) {
            return Optional.of(data[0]);
        } else if (data.length > 1) {
            rsl = Optional.of(data[0]);
            for (int index = 1; index < data.length; index++) {
                if (data[index] > rsl.get()) {
                    rsl = Optional.of(data[index]);
                }
            }
        }
        return rsl;
    }
}