package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("BMW");
        autos.add("Toyota");
        for (String var : autos) {
            System.out.println(var);
        }
    }
}