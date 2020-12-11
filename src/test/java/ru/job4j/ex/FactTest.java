package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
        Fact fact = new Fact();
        int rsl = fact.calc(-3);
        assertThat(rsl, is(6));
    }
}