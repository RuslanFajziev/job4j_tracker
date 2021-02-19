package ru.job4j.stream;

public class Builder {
    private String brand;
    private String model;
    private String transmission;
    private String fuelType;
    private Boolean spoller;
    private Boolean sportCar;
    private Boolean hydroAmplifier;

    Builder buildBrand(String brand) {
        this.brand = brand;
        return this;
    }

    Builder buildModel(String model) {
        this.model = model;
        return this;
    }

    Builder buildTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    Builder buildFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    Builder buildSpoller(Boolean spoller) {
        this.spoller = spoller;
        return this;
    }

    Builder buildSportCar(Boolean sportCar) {
        this.sportCar = sportCar;
        return this;
    }

    Builder buildHydroAmplifier(Boolean hydroAmplifier) {
        this.hydroAmplifier = hydroAmplifier;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.brand = brand;
        car.model = model;
        car.transmission = transmission;
        car.fuelType = fuelType;
        car.spoller = spoller;
        car.sportCar = sportCar;
        car.hydroAmplifier = hydroAmplifier;
        return car;
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("BMW")
                .buildModel("E36")
                .buildTransmission("Mechanics")
                .buildFuelType("AU-95")
                .buildSpoller(true)
                .buildSportCar(false)
                .buildHydroAmplifier(true)
                .build();
        System.out.println(car);

        Car car2 = new Builder().buildBrand("BMW")
                .buildModel("E36")
                .buildTransmission("Mechanics")
                .buildFuelType("AU-95")
                .build();
        System.out.println(car2);
    }
}