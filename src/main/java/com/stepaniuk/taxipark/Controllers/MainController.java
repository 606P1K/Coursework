package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;

public class MainController {
    @FXML // fx:id="makeButton"
    private Button makeButton; // Value injected by FXMLLoader

    @FXML
    void make(ActionEvent event) throws IOException {
        LogClass.logger.info("Use the make method");
        DBCommands.isEmpty();
        goToMenuButton(event);
    }

}