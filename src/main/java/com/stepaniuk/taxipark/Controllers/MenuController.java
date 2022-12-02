package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.stepaniuk.taxipark.Controllers.Universal.ChangeStage.changeStage;

public class MenuController {

    @FXML
    private Button addCarButton;

    @FXML
    private Button clearCarParkButton;


    @FXML
    private Button findSpecificCarsButton;

    @FXML
    private Button priceOfCarParkButton;

    @FXML
    private Button showCarParkButton;

    @FXML
    private Button showInfoButton;

    @FXML
    private Button sortCarParkButton;

    @FXML
    void addCar(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the scene of adding a car to the list");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/add.fxml");
    }

    @FXML
    void clearCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the car list clearing scene");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/clear.fxml");
    }

    @FXML
    void findSpecificCars(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the auto search scene with certain parameters");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/find.fxml");
    }

    @FXML
    void getPriceOfCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the carpark price output scene");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/getPrice.fxml");
    }

    @FXML
    void showCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the carpark price output scene");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/show.fxml");
    }

    @FXML
    void showInfoAboutCar(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the auto output scene under a certain index");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/showInfoAboutCar.fxml");
    }

    @FXML
    void sortCarPark(ActionEvent event) throws IOException {
        LogClass.logger.info("The menu scene has been changed to the carpark sorting scene");
        changeStage(event,"src/main/resources/com/stepaniuk/taxipark/sort.fxml");
    }
}

