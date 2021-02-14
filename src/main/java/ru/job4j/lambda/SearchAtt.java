package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> fun) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (fun.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> prdA = z -> z.getSize() > 100;
        return filter(list, prdA);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> prdA2 = w -> {
            return w.getName().contains("bug");
        };
        return filter(list, prdA2);
    }

    public static List<Attachment> sortSize(List<Attachment> list) {
        Comparator<Attachment> cmpAtt = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        list.sort(cmpAtt);
        return list;
    }

    public static void main(String[] args) {
        List<Attachment> lst = Arrays.asList(
                new Attachment("ficha", 150),
                new Attachment("ficha", 101),
                new Attachment("bug", 50),
                new Attachment("bug", 25),
                new Attachment("bug", 120)
        );

        System.out.println("-------------------------------");
        lst.forEach(System.out::println);
        System.out.println("-------------------------------");
        filterSize(lst).forEach(System.out::println);
        System.out.println("-------------------------------");
        filterName(lst).forEach(System.out::println);
        System.out.println("-------------------------------");
        sortSize(lst).forEach(System.out::println);
        System.out.println("-------------------------------");
    }
}