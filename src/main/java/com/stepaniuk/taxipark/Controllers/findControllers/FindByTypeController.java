package com.stepaniuk.taxipark.Controllers.findControllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Car.CarType;
import com.stepaniuk.taxipark.Car.TaxiCar;
import com.stepaniuk.taxipark.Database.DBCommands;
import com.stepaniuk.taxipark.Database.TaxiConst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.stepaniuk.taxipark.Car.CarType.*;
import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class FindByTypeController implements Initializable {

    @FXML
    private Button findCarsButton;

    @FXML
    private TextArea foundedCarsTextArea;

    @FXML
    private Button goToMenuButton;

    @FXML
    private ChoiceBox<CarType> typeOfCarBox;
    private final CarType[] carType = {STANDARD,COMFORT,BUSINESS};
    private CarType selectedCarType;

    @FXML
    void findCars(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the findCars method(by carType)");
        List<TaxiCar> list = DBCommands.getCarsQuery("SELECT * FROM " + TaxiConst.TAXI_TABLE + " WHERE "+TaxiConst.CAR_TYPE
                +" = '"+selectedCarType+"'");
        if (list.isEmpty()){
            LogClass.logger.warn("The list of cars was empty");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Find,Display/findMenu.fxml");}
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeOfCarBox.getItems().addAll(carType);
        typeOfCarBox.setOnAction(this::getCarType);
    }

    private void getCarType(ActionEvent event){
        selectedCarType = typeOfCarBox.getValue();
    }
}

