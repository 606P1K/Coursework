package com.stepaniuk.taxipark.Database;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.stepaniuk.taxipark.Database.DBHandler.getDbConnection;

public class DBCommands {
    private static boolean booleanEmpty = true;

    public static List<TaxiCar> findCar(int lowerSpeedLimit, int upperSpeedLimit){
        LogClass.logger.info("Use the findCar method");
        String getInfo = "SELECT * FROM " + TaxiConst.TAXI_TABLE +" WHERE "+ TaxiConst.MAX_SPEED+" > "
                +lowerSpeedLimit+" AND "+ TaxiConst.MAX_SPEED+ " < "+upperSpeedLimit;
        return getCarsQuery(getInfo);
    }

    public static List<TaxiCar> getTaxiPark(){
        LogClass.logger.info("Use the getTaxiPark method");
        String getInfo = "SELECT * FROM " + TaxiConst.TAXI_TABLE;
        return getCarsQuery(getInfo);
    }

    public static Double getPrice(){
        LogClass.logger.info("Use the getPrice method");
        String qry = "SELECT SUM("+ TaxiConst.PRICE+") FROM "+ TaxiConst.TAXI_TABLE;
        double price = 0.0;
        if(!booleanEmpty){
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(qry);
                ResultSet resultSet = prSt.executeQuery();
                while( resultSet.next() ) {
                    price += Double.parseDouble(resultSet.getString(1));
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return price;
    }

    public static List<TaxiCar> getCarsQuery(String qry){
        LogClass.logger.info("Use the getCarsQuery method");
        List<TaxiCar> cars = new ArrayList<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(qry);
            ResultSet resultSet = prSt.executeQuery();
            while(resultSet.next()){
                cars.add(new TaxiCar(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),
                        Integer.parseInt(resultSet.getString(4)), Double.parseDouble(resultSet.getString(5)),
                        Double.parseDouble(resultSet.getString(6)),Double.parseDouble(resultSet.getString(7)),
                        Integer.parseInt(resultSet.getString(8)),Double.parseDouble(resultSet.getString(9)),
                        TransmissionType.valueOf(resultSet.getString(10)),WheelDriveType.valueOf(resultSet.getString(11)),
                        GasolineType.valueOf(resultSet.getString(12)),CarType.valueOf(resultSet.getString(13))));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public static boolean isUniqueNumber(String number){
        LogClass.logger.info("Use the isUniqueNumber method");
        String qry = "SELECT * FROM "+ TaxiConst.TAXI_TABLE+" WHERE "+TaxiConst.CAR_NUMBER+" = '"+ number+"'";
        boolean isUnique = true;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(qry);
            ResultSet resultSet = prSt.executeQuery();
            while( resultSet.next() ) {
                isUnique = false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       return isUnique;
    }

    public static List<String> getCarName(String qry){
        LogClass.logger.info("Use the getCarName method");
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(qry);
            ResultSet resultSet = prSt.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addCar(String carName, int maxSpeed, double tankCapacity, double engineCapacity, double price, int yearOfManufacture, double fuelConsumptionPerHundred, String gasolineType, String carType, String carNumber, String transmissionType, String wheelDriveType) {
        LogClass.logger.info("Use the addCar method(DBCommands)");
        String insert = "INSERT INTO "  + TaxiConst.TAXI_TABLE + "(" +
                TaxiConst.CAR_NAME + "," + TaxiConst.CAR_NUMBER + "," + TaxiConst.MAX_SPEED + ","
                + TaxiConst.TANK_CAPACITY + "," + TaxiConst.ENGINE_CAPACITY + "," + TaxiConst.PRICE +
                "," + TaxiConst.YEARS_OF_MANUFACTURE + "," + TaxiConst.FUEL_CONSUMPTION_PER_HUNDRED +
                "," + TaxiConst.TRANSMISSION_TYPE +"," + TaxiConst.WHEEL_DRIVE_TYPE +
                "," + TaxiConst.TYPE_OF_GASOLINE +"," + TaxiConst.CAR_TYPE +")" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, carName);
            prSt.setString(2, carNumber);
            prSt.setInt(3, maxSpeed);
            prSt.setDouble(4, tankCapacity);
            prSt.setDouble(5, engineCapacity);
            prSt.setDouble(6, price);
            prSt.setInt(7, yearOfManufacture);
            prSt.setDouble(8, fuelConsumptionPerHundred);
            prSt.setString(9, transmissionType);
            prSt.setString(10, wheelDriveType);
            prSt.setString(11, gasolineType);
            prSt.setString(12, carType);
            prSt.executeUpdate();
            booleanEmpty = false;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void isEmpty(){
        LogClass.logger.info("Use the isEmpty method");
        String qry = "SELECT * FROM "+ TaxiConst.TAXI_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(qry);
            ResultSet resultSet = prSt.executeQuery();
            while( resultSet.next() ) {
                booleanEmpty = false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearTable(){
        LogClass.logger.info("Use the clearTable method");
        String delete = "DELETE FROM "+TaxiConst.TAXI_TABLE +
                " DBCC CHECKIDENT ("+TaxiConst.TAXI_TABLE+", RESEED, 0)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        booleanEmpty = true;
    }
}
