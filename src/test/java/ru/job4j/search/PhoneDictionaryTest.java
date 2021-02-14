package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary2 phones = new PhoneDictionary2();
        phones.add(
                new Person2("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person2("Ruslan", "Faiziev", "555444", "Moscow")
        );
        ArrayList<Person2> persons = phones.find("Faiziev");
        assertThat(persons.get(0).getAddress(), is("Moscow"));
    }
}