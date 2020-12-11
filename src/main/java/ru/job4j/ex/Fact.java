package ru.job4j.ex;

public class Fact {
    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less then 0");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println(fact.calc(3));
        System.out.println(fact.calc(-10));
    }
}