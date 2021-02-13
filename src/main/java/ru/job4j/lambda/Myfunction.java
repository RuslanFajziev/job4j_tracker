package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Myfunction {
    public static List<Double> diapason(double start, double end, Function<Double, Double> func) {
        List<Double> lst = new ArrayList<Double>();
        for (double index = start; index < end; index++) {
            lst.add(func.apply(index));
        }
        return lst;
    }
}