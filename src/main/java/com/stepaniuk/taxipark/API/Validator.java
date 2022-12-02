package com.stepaniuk.taxipark.API;

import com.stepaniuk.taxipark.Database.DBCommands;

import java.time.Year;
import java.util.Map;
import java.util.function.Supplier;

public class Validator {
    public static String validData(String carNumber,int maximalSpeed,double tankCapacity,double engineCapacity,
                                   double price,int yearOfManufacture,double fuelConsumption){
        String []commands = {"carNumber","maxSpeed","tankCapacity","engineCapacity","price","yearOfManufacture",
                "fuelConsumption"};
        boolean isValid;
        for (int i = 0; i < commands.length; i++) {
            switch (i){
                case 0 -> isValid = DBCommands.isUniqueNumber(carNumber);
                case 1 -> isValid = Validator.validator(commands[i],String.valueOf(maximalSpeed));
                case 2 -> isValid = Validator.validator(commands[i],String.valueOf(tankCapacity));
                case 3 -> isValid = Validator.validator(commands[i],String.valueOf(engineCapacity));
                case 4 -> isValid = Validator.validator(commands[i],String.valueOf(price));
                case 5 -> isValid = Validator.validator(commands[i],String.valueOf(yearOfManufacture));
                default -> isValid = Validator.validator(commands[i],String.valueOf(fuelConsumption));
            }
            if(!isValid){
                LogClass.logger.warn("Data validation failed. The field that caused the error: "+commands[i]);
                return commands[i];
            }
        }
        LogClass.logger.warn("Data validation is successful.");
        return "Valid";

    }
    private static boolean validator(String command,String  check){
        Map<String, Supplier<Boolean>> commandMap = Map.of(
                "maxSpeed",()->{
                    int maxSpeed = Integer.parseInt(check);
                    return maxSpeed>0&&maxSpeed<490;
                },
                "tankCapacity",()->{
                    double tankCapacity = Double.parseDouble(check);
                    return tankCapacity >0&& tankCapacity <120;
                },
                "engineCapacity",()->{
                    double engineCapacity = Double.parseDouble(check);
                    return engineCapacity >0&& engineCapacity <8000;
                },
                "price",()->{
                    double price = Double.parseDouble(check);
                    return price >0;
                },
                "yearOfManufacture",()->{
                    int yearOfManufacture = Integer.parseInt(check);
                    return yearOfManufacture>1885&&yearOfManufacture<= Year.now().getValue();
                },
                "fuelConsumption",()->{
                    double fuelConsumption = Double.parseDouble(check);
                    return fuelConsumption >0&& fuelConsumption <50;
                }
        );
        return commandMap.get(command).get();
    }

}
