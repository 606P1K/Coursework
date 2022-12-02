package com.stepaniuk.taxipark.Controllers.Universal;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChangeStage {
    public static void changeStage(ActionEvent event, String pathname) throws IOException {
        LogClass.logger.info("The method to change stage was used");
        URL url = new File(pathname).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(new File("src/main/resources/com/stepaniuk/taxipark/img/taxiIcon.png").toURI().toString()));
        stage.setScene(scene);
        stage.show();
    }
}
