package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentFiltering {
    public static Map<String, Student> filtering(List<Student> lstStudt) {
        return lstStudt.stream().distinct().collect(Collectors.toMap(x -> x.getSurname(), x -> x));
    }
}
