package com.stepaniuk.taxipark.Controllers.TipsControllers;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FindMenuController {

    @FXML
    private Button closeButton;

    @FXML
    void closeButton(ActionEvent event) {
        LogClass.logger.info("Find tips was closed!");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
