package com.stepaniuk.taxipark.Car;

import com.stepaniuk.taxipark.API.LogClass;

public class TaxiCar {
    private final int carID;
    private final String carName;
    private final String carNumber;
    private final int maxSpeed;
    private final double tankCapacity;
    private final double engineCapacity;
    private final double price;
    private final int yearOfManufacture;
    private final double fuelConsumptionPerHundred;
    private final TransmissionType transmissionType;
    private final WheelDriveType wheelDriveType;
    private final GasolineType typeOfGasoline;
    private final CarType carType;

    public TaxiCar(int carID,String carName, String carNumber, int maxSpeed, double tankCapacity, double engineCapacity, double price, int yearOfManufacture, double fuelConsumptionPerHundred, TransmissionType transmissionType, WheelDriveType wheelDriveType, GasolineType typeOfGasoline, CarType carType) {
        this.carID = carID;
        this.carName = carName;
        this.carNumber = carNumber;
        this.maxSpeed = maxSpeed;
        this.tankCapacity = tankCapacity;
        this.engineCapacity = engineCapacity;
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.fuelConsumptionPerHundred = fuelConsumptionPerHundred;
        this.transmissionType = transmissionType;
        this.wheelDriveType = wheelDriveType;
        this.typeOfGasoline = typeOfGasoline;
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public double getFuelConsumptionPerHundred() {
        return fuelConsumptionPerHundred;
    }

    public int getCarID() {
        return carID;
    }

    @Override
    public String toString() {
        LogClass.logger.info("Use the method toString(TaxiCar)");
        return  carName +":"+
                "\n    Number: " + carNumber +
                "\n    Maximum speed(km/h): " + maxSpeed +
                "\n    Tank capacity(L): " + tankCapacity +
                "\n    Engine Capacity(m3): " + engineCapacity +
                "\n    Price($): " + price +
                "\n    Year of manufacture: " + yearOfManufacture+
                "\n    Type of transmission: "+transmissionType+
                "\n    Type of wheel drive: " + wheelDriveType+
                "\n    Fuel consumption per 100 km: "+fuelConsumptionPerHundred+" L"+
                "\n    Type of the car: " + carType+
                "\n    Type of gasoline: "+typeOfGasoline;
    }
}
