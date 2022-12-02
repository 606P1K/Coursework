package com.stepaniuk.taxipark.Controllers.findControllers;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.stepaniuk.taxipark.Controllers.Universal.ChangeStage.changeStage;
import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;

public class FindController implements Initializable {

    @FXML
    private Button findCarsButton;
    @FXML
    private ChoiceBox<String> listBox;
    @FXML
    private Button goToMenuButton;
    private final String[] select = {"Speed","Number","Type"};
    private String selected;
    @FXML
    void findCars(ActionEvent event) throws IOException {
        LogClass.logger.info("Car(s) search criteria was selected");
        switch (selected){
            case "Speed" -> changeStage(event,"src/main/resources/com/stepaniuk/taxipark/findBySpeed.fxml");
            case "Number" -> changeStage(event,"src/main/resources/com/stepaniuk/taxipark/findByNumber.fxml");
            default -> changeStage(event,"src/main/resources/com/stepaniuk/taxipark/findByType.fxml");
        }
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LogClass.logger.info("Initialize the choiceBox with data");
        listBox.getItems().addAll(select);
        listBox.setOnAction(this::getSelected);
    }

    private void getSelected(ActionEvent event){
        selected = listBox.getValue();
    }

}

