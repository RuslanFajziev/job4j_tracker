package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary2 {
    ArrayList<Person2> person = new ArrayList<Person2>();

    public void add(Person2 person) {
        this.person.add(person);
    }

    public ArrayList<Person2> find(String key) {
        ArrayList<Person2> result = new ArrayList<>();
        ArrayList<Person2> per = this.person;
        for (int index = 0; index < per.size(); index++) {
            if (per.get(index).getName().contains(key)
                    || per.get(index).getSurname().contains(key)
                    || per.get(index).getPhone().contains(key)
                    || per.get(index).getAddress().contains(key)) {
                result.add(per.get(index));
            }
        }
        return result;
    }
}
