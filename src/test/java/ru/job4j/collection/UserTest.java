package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAscT() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 30));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 30)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAscT2() {
        Set<User> users = new TreeSet<>();
        Set<User> usrSecond = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 30));
        usrSecond.add(new User("Ivan", 30));
        usrSecond.add(new User("Ivan", 31));
        usrSecond.add(new User("Petr", 32));
        assertThat(users, is(usrSecond));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareIvanVSIvan() {
        int rsl = new User("Ivan", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenCompareIvanVSIvan2() {
        int rsl = new User("Ivan", 32)
                .compareTo(
                        new User("Ivan", 33)
                );
        assertThat(rsl, is(-1));
    }
}