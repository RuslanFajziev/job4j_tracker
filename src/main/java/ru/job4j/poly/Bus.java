package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void toGo() {
        System.out.println("Дорогие пассажиры.");
    }

    @Override
    public void passengers(int pass) {
        int passAuto = pass;
    }

    @Override
    public int refill(int quaBenz) {
        return quaBenz * 45;
    }
}
