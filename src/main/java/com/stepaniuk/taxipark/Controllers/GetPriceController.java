package com.stepaniuk.taxipark.Controllers;

import com.stepaniuk.taxipark.API.LogClass;
import com.stepaniuk.taxipark.Database.DBCommands;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

import static com.stepaniuk.taxipark.Controllers.Universal.GoToMenuButton.goToMenuButton;

public class GetPriceController {

    @FXML
    private Button getPriceButton;

    @FXML
    private Button goToMenuButton;

    @FXML
    private Label priceLabel;

    @FXML
    void getPrice(ActionEvent event) {
        LogClass.logger.info("The price of the carpark was displayed");
        String price = String.valueOf(DBCommands.getPrice());
        priceLabel.setText(price+"$");
    }

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
        goToMenuButton(event);
    }

}
