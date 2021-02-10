package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, UnaryOperator<List<Attachment>> fun) {
        return fun.apply(list);
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> lst = new ArrayList<Attachment>();
        UnaryOperator<List<Attachment>> cns = x -> {
            for (Attachment elm : x) {
                if (elm.getSize() > 100) {
                    lst.add(elm);
                }
            }
            return lst;
        };
//        return cns.apply(list);
        return filter(list, cns);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> lst2 = new ArrayList<Attachment>();
        UnaryOperator<List<Attachment>> cns2 = y -> {
            for (Attachment elm : y) {
                if (elm.getName().contains("bug")) {
                    lst2.add(elm);
                }
            }
            return lst2;
        };
//        return cns2.apply(list);
        return filter(list, cns2);
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