package ru.job4j.stream;

class Car {
    String brand;
    String model;
    String transmission;
    String fuelType;
    Boolean spoller;
    Boolean sportCar;
    Boolean hydroAmplifier;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", transmission='" + transmission + '\''
                + ", fuelType='" + fuelType + '\''
                + ", spoller=" + spoller
                + ", sportCar=" + sportCar
                + ", hydroAmplifier=" + hydroAmplifier
                + '}';
    }
}
