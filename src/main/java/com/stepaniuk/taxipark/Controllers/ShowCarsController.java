package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.TaxiCar;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.util.List;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class ShowCarsController {

    @FXML
    private Button goToMenuButton;

    @FXML
    private TextArea listCarsTextArea;

    @FXML
    private Button showCarsButton;

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

    @FXML
    void showCars(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the showCars method to display cars");
        List<TaxiCar> list = DBCommands.getTaxiPark();
        if(list.isEmpty()){
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Empty/wasEmpty.fxml");}
        else{
            StringBuilder sb = new StringBuilder();
            for(TaxiCar e : list){
                sb.append(e.getCarName()).append(" - ").append(e.getCarNumber()).append("\n");
            }
            LogClass.logger.info("Cars were put on display");
            listCarsTextArea.setText(sb.toString());
        }
    }

}

