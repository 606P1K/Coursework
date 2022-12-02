package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.API.Validator;
import com.stepaniuk.taxipark.Car.*;
import com.stepaniuk.taxipark.Controllers.TipsControllers.RefusalMenuController;
import com.stepaniuk.taxipark.Database.CarsConst;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;
import static com.stepaniuk.taxipark.Controllers.Universal.CallTips.callTips;

public class AddCarController implements Initializable{

    @FXML
    private Button addCarButton;

    @FXML
    private ChoiceBox<String> carCompanyBox;

    @FXML
    private ChoiceBox<String> carModelBox;
    @FXML
    private ChoiceBox<GasolineType> gasolineTypeBox;
    @FXML
    private ChoiceBox<CarType> carTypeBox;
    @FXML
    private ChoiceBox<TransmissionType> transmissionBox;

    @FXML
    private ChoiceBox<WheelDriveType> wheelDriveBox;
    @FXML
    private TextField carNumberField;

    @FXML
    private TextField engineCapacityField;

    @FXML
    private TextField fuelConsumptionField;

    @FXML
    private TextField maximalSpeedField;

    @FXML
    private Button menuButton;

    @FXML
    private TextField priceField;

    @FXML
    private TextField tankCapacityField;

    @FXML
    private TextField yearOfManufactureField;
    private final CarType[] carType = CarType.values();
    private final GasolineType[] gasolineType = GasolineType.values();
    private final WheelDriveType[] wheelDriveType = WheelDriveType.values();
    private final TransmissionType[] transmissionType = TransmissionType.values();
    private GasolineType selectedGasolineType;
    private CarType selectedCarType;
    private TransmissionType selectedTransmissionType;
    private WheelDriveType selectedWheelDriveType;
    private String selectedCarCompany;
    private String selectedCarModel;

    @FXML
    void addCar(ActionEvent event) throws IOException {
        LogClass.logger.info("Add car method was used(AddCarController)!");
        int maxSpeed = Integer.parseInt(maximalSpeedField.getText());
        double tankCapacity =  Double.parseDouble(tankCapacityField.getText());
        double engineCapacity = Double.parseDouble(engineCapacityField.getText());
        double price = Double.parseDouble(priceField.getText());
        int yearOfManufacture = Integer.parseInt(yearOfManufactureField.getText());
        double fuelConsumption = Double.parseDouble(fuelConsumptionField.getText());
        String carNumber = carNumberField.getText();
        String isValid = Validator.validData(carNumber,maxSpeed,tankCapacity,engineCapacity,price,yearOfManufacture,fuelConsumption);
        if(isValid.equals("Valid")){
            DBCommands.addCar((selectedCarCompany+" "+selectedCarModel),maxSpeed,
                    tankCapacity,engineCapacity,
                    price,yearOfManufacture,fuelConsumption
                    ,String.valueOf(selectedGasolineType),String.valueOf(selectedCarType),
                    carNumber,String.valueOf(selectedTransmissionType),String.valueOf(selectedWheelDriveType));
            LogClass.logger.info("The car was added to the database");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Add/AcceptMenu.fxml");
            clearTextField();
            clearBoxes();
        }else{
            LogClass.logger.info("The refusal tips was displayed");
            callTips("src/main/resources/com/stepaniuk/taxipark/tips/Add/RefusalMenu.fxml");
        }
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

    @FXML
    void setModel(MouseEvent event) {
        LogClass.logger.info("Initialize the choiceBox of car model with data");
        if (!carModelBox.getItems().isEmpty())
            carModelBox.getItems().clear();
        carModelBox.getItems().addAll(DBCommands.getCarName("SELECT "+CarsConst.CAR_MODEL+" FROM "+CarsConst.CARS_TABLE+ " WHERE "+CarsConst.CAR_COMPANY+" = '"+selectedCarCompany+"'"));
        carModelBox.setOnAction(this::getModel);
    }

    void clearTextField(){
        LogClass.logger.info("All fields have been cleared");
        carNumberField.clear();
        maximalSpeedField.clear();
        tankCapacityField.clear();
        engineCapacityField.clear();
        priceField.clear();
        yearOfManufactureField.clear();
        fuelConsumptionField.clear();
    }

    void clearBoxes(){
        LogClass.logger.info("All boxes have been cleared");
        carCompanyBox.getSelectionModel().clearSelection();
        carModelBox.getSelectionModel().clearSelection();
        transmissionBox.getSelectionModel().clearSelection();
        wheelDriveBox.getSelectionModel().clearSelection();
        carTypeBox.getSelectionModel().clearSelection();
        gasolineTypeBox.getSelectionModel().clearSelection();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LogClass.logger.info("Initialize the choiceBox with data");
        gasolineTypeBox.getItems().addAll(gasolineType);
        gasolineTypeBox.setOnAction(this::getGasolineType);

        carTypeBox.getItems().addAll(carType);
        carTypeBox.setOnAction(this::getCarType);

        transmissionBox.getItems().addAll(transmissionType);
        transmissionBox.setOnAction(this::getTransmissionType);

        wheelDriveBox.getItems().addAll(wheelDriveType);
        wheelDriveBox.setOnAction(this::getWheelDriveType);

        carCompanyBox.getItems().addAll(DBCommands.getCarName("SELECT DISTINCT " + CarsConst.CAR_COMPANY + " FROM "+CarsConst.CARS_TABLE));
        carCompanyBox.setOnAction(this::getCompany);
    }
    private void getGasolineType(ActionEvent event){
        selectedGasolineType = gasolineTypeBox.getValue();
    }
    private void getCarType(ActionEvent event){
        selectedCarType = carTypeBox.getValue();
    }

    private void getTransmissionType(ActionEvent event){
        selectedTransmissionType = transmissionBox.getValue();
    }

    private void getWheelDriveType(ActionEvent event){
        selectedWheelDriveType = wheelDriveBox.getValue();
    }
    private void getCompany(ActionEvent event){
        selectedCarCompany = carCompanyBox.getValue();
    }
    private void getModel(ActionEvent event){
        selectedCarModel = carModelBox.getValue();
    }
}
