package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private EasyElement easyElement;
    private static EasyStream instance;

    private EasyStream() {
    }

    public static EasyStream getInstance() {
        if (instance == null) {
            instance = new EasyStream();
        }
        return instance;
    }

    public EasyElement getEasyElement() {
        return easyElement;
    }

    public void setEasyElement(EasyElement easyElement) {
        this.easyElement = easyElement;
    }

    public static EasyStream of(List<Integer> source) {
        EasyElement easyElement = new EasyElement();
        easyElement.setIntInput(source);
        getInstance().setEasyElement(easyElement);
        return getInstance();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> intInput = getInstance().getEasyElement().getIntInput();
        for (int index = 0; index < intInput.size(); index++) {
            intInput.set(index, fun.apply(intInput.get(index)));
        }
        return getInstance();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> intInput = easyElement.getIntInput();
        for (int index = 0; index < intInput.size(); index++) {
            Integer intTmp = intInput.get(index);
            if (!fun.test(intTmp)) {
                intInput.remove(intTmp);
                index--;
            }
        }
        return getInstance();
    }

    public List<Integer> collect() {
        return easyElement.getIntInput();
    }
}