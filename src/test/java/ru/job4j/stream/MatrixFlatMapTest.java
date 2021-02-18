package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixFlatMapTest {
    @Test
    public void checkFlatMap() {
        Integer[][] array = {
                {4, 2, 3},
                {7, 1, 5},
                {3, 5, 6}
        };
        List<Integer> lstInt = MatrixFlatMap.flatMap(array);
        List<Integer> lstIntCheck = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThat(lstIntCheck, is(lstInt));
    }
}