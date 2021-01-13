package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    final private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        String citKey = citizen.getPassport();
        if (!citizens.containsKey(citKey)) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}