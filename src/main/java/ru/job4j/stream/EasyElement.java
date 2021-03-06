package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;

public class EasyElement {
    private List<Integer> intInput = new ArrayList<Integer>();

    public void setIntInput(List<Integer> src) {
            this.intInput.addAll(src);
    }

    public List<Integer> getIntInput() {
        return intInput;
    }
}