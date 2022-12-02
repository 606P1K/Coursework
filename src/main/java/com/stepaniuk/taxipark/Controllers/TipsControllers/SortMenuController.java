package com.stepaniuk.taxipark.Controllers.TipsControllers;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SortMenuController {

    @FXML
    private Button backButton;

    @FXML
    void backButton(ActionEvent event) {
        LogClass.logger.info("Sort tips was closed!");
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
