package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.TaxiCar;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Comparator;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class SortController {

    @FXML
    private Button goToMenuButton;

    @FXML
    private Button sortButton;

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

    @FXML
    void sortCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the sortCarPark method to sort carpark by fuelConsumption");
        Comparator<TaxiCar> comparator = Comparator.comparing(TaxiCar::getFuelConsumptionPerHundred);
        if(DBCommands.getTaxiPark().isEmpty()){
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Empty/wasEmpty.fxml");}
        else{
            LogClass.logger.info("The list of cars was sorted");
            DBCommands.getTaxiPark().sort(comparator);
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Sort/SortMenu.fxml");
        }
    }

}

