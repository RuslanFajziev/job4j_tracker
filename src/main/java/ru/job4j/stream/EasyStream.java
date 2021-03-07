package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> intInput;

    private EasyStream(List<Integer> intInput) {
        this.intInput = intInput;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> intInputTmp = new ArrayList<>();
        for (int index = 0; index < intInput.size(); index++) {
            intInputTmp.add(fun.apply(intInput.get(index)));
        }
        return new EasyStream(intInputTmp);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> intInputTmp = new ArrayList<>();
        for (int index = 0; index < intInput.size(); index++) {
            Integer intTmp = intInput.get(index);
            if (fun.test(intTmp)) {
                intInputTmp.add(intTmp);
            }
        }
        return new EasyStream(intInputTmp);
    }

    public List<Integer> collect() {
        return intInput;
    }
}