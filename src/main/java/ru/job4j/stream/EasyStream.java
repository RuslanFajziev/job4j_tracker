package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    static List<Integer> intInput;

    public static EasyStream of(List<Integer> source) {
//        throw new UnsupportedOperationException();
        intInput.addAll(source);
        return EasyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
//        throw new UnsupportedOperationException();
        for (int index = 0; index < intInput.size(); index++) {
            intInput.set(index, fun.apply(intInput.get(index)));
        }
        return EasyStream;
    }

    public EasyStream filter(Predicate<Integer> fun) {
//        throw new UnsupportedOperationException();
        for (int index = 0; index < intInput.size(); index++) {
            Integer intTmp = intInput.get(index);
            if (!fun.test(intTmp)) {
                intInput.remove(intTmp);
                index--;
            }
        }
        return EasyStream;
    }

    public List<Integer> collect() {
//        throw new UnsupportedOperationException();
        return intInput;
    }
}