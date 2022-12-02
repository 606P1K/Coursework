package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;


public class ShowInfoByIndexController {
    @FXML
    private Button goToMenuButton;

    @FXML
    private TextField idOfCar;

    @FXML
    private TextArea carTextArea;

    @FXML
    private Button showCarButton;

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

    @FXML
    void showCar(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the showCar method to display the car under the given index");
        int id = Integer.parseInt(idOfCar.getText());
        if(id<=0 || id > DBCommands.getTaxiPark().size()){
            LogClass.logger.warn("An invalid car index was entered");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Find,Display/displayMenu.fxml");
        }
        else {
            LogClass.logger.info("Car was put on display");
            carTextArea.setText(DBCommands.getTaxiPark().get(id - 1).toString());
        }
    }

}

