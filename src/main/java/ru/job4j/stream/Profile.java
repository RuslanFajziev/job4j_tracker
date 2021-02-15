package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;
    private int age;
    private Boolean athlete;

    public Profile(Address address, int age, Boolean athlete) {
        this.address = address;
        this.age = age;
        this.athlete = athlete;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Boolean getAthlete() {
        return athlete;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(x -> x.address)
                .collect(Collectors.toList());
    }
}