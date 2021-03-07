package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    final List<Integer> intInput = new ArrayList<>();

    private EasyStream(List<Integer> intInput) {
        this.intInput.addAll(intInput);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int index = 0; index < intInput.size(); index++) {
            intInput.set(index, fun.apply(intInput.get(index)));
        }
        return new EasyStream(intInput);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        for (int index = 0; index < intInput.size(); index++) {
            Integer intTmp = intInput.get(index);
            if (!fun.test(intTmp)) {
                intInput.remove(intTmp);
                index--;
            }
        }
        return new EasyStream(intInput);
    }

    public List<Integer> collect() {
        return intInput;
    }
}