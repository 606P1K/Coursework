package com.stepaniuk.taxipark.Controllers.Universal;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TipsController {

    @FXML
    private Button closeButton;

    @FXML
    void closeButton(ActionEvent event) {
        LogClass.logger.info("Tips was closed!");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
