package com.stepaniuk.taxipark.Controllers.Universal;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CallTips {
    public static void callTips(String pathname) throws IOException {
        LogClass.logger.info("The method to call tips was used");
        URL url = new File(pathname).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Taxipark");
        stage.getIcons().add(new Image(new File("src/main/resources/com/stepaniuk/taxipark/img/taxiIcon.png").toURI().toString()));
        stage.setScene(scene);
        stage.show();
    }
}
