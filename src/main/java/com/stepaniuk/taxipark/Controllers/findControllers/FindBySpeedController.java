package com.stepaniuk.taxipark.Controllers.findControllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.TaxiCar;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class FindBySpeedController {

    @FXML
    private Button findCarsButton;

    @FXML
    private TextArea foundedCarsTextArea;

    @FXML
    private Button goToMenuButton;

    @FXML
    private TextField lowerSpeedField;

    @FXML
    private TextField upperSpeedField;

    @FXML
    void findCars(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the findCars method(by speed limits)");
        int upperSpeedLimit = Integer.parseInt(upperSpeedField.getText());
        int lowerSpeedLimit = Integer.parseInt(lowerSpeedField.getText());
        List<TaxiCar> list = DBCommands.findCar(lowerSpeedLimit,upperSpeedLimit);
        if (list.isEmpty()){
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Find,Display/findMenu.fxml");
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(TaxiCar e : list){
                sb.append(e.getCarName()).append("\tid: ").append(e.getCarID()).append("\n");
            }
            LogClass.logger.info("Car were put on display");
            foundedCarsTextArea.setText(sb.toString());
        }
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

}

