package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class ClearCarParkController {

    @FXML
    private Button clearButton;

    @FXML
    private Button goToMenuButton;

    @FXML
    void clearCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the clearCarPark method");
        if(!DBCommands.getTaxiPark().isEmpty()){
            DBCommands.clearTable();
            LogClass.logger.info("The list of cars has been cleared");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Clear/clearMenu.fxml");
        }
        else{
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Empty/wasEmpty.fxml");}
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
       goToMenuButton(event);
    }

}
