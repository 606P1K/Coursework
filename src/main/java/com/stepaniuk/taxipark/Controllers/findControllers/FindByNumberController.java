package com.stepaniuk.taxipark.Controllers.findControllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.TaxiCar;
import com.stepaniuk.taxipark.Database.TaxiConst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Database.DBCommands.getCarsQuery;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class FindByNumberController {

    @FXML
    private Button findCarButton;

    @FXML
    private TextArea foundedCarTextArea;

    @FXML
    private Button goToMenuButton;

    @FXML
    private TextField numberField;

    @FXML
    void findCar(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the findCars method(by number)");
        String number = numberField.getText();
        List<TaxiCar> car = getCarsQuery("SELECT * FROM " + TaxiConst.TAXI_TABLE + " WHERE "+TaxiConst.CAR_NUMBER
        +" = '"+number+"'");
        if (car.isEmpty()){
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Find,Display/findMenu.fxml");}
        else{
            LogClass.logger.info("Car was put on display");
            foundedCarTextArea.setText(car.get(0).getCarName()+"\tid: " + car.get(0).getCarID());
        }
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

}