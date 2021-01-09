package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    ArrayList<Person> person = new ArrayList<Person>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        ArrayList<Person> per = this.person;
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
