package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentFilteringTest {
    @Test
    public void mapTest() {
        Student std1 = new Student(1, "Petros");
        Student std2 = new Student(2, "Ivanos");
        Student std3 = new Student(3, "Sidorov");

        List<Student> lstStudt = List.of(std1, std1, std2, std2, std3);
        Map<String, Student> mapStd = StudentFiltering.filtering(lstStudt);
        Map<String, Student> mapStdCheck = new HashMap<>();
        mapStdCheck.putIfAbsent(std1.getSurname(), std1);
        mapStdCheck.putIfAbsent(std2.getSurname(), std2);
        mapStdCheck.putIfAbsent(std2.getSurname(), std2);
        mapStdCheck.putIfAbsent(std3.getSurname(), std3);
        assertThat(mapStdCheck, is(mapStd));
    }
}