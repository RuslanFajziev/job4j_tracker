package ru.job4j.oop;

public class Battery {
    private int load;
    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery enother) {
        enother.load += this.load;
        this.load -= this.load;
    }

    public static void main(String[] args) {
        Battery testOne = new Battery(100);
        Battery testTwo = new Battery(20);
        System.out.println("testOne : " + testOne.load + ". testTwo : " + testTwo.load);
        testOne.exchange(testTwo);
        System.out.println("testOne : " + testOne.load + ". testTwo : " + testTwo.load);
    }
}
