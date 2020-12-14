package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index] == key) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Index must not be negative");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arrayStr = {"Vasay", "Petay"};
        try {
            indexOf(arrayStr, "Vasay1");
        } catch (ElementNotFoundException u) {
            u.printStackTrace();
        }
    }
}