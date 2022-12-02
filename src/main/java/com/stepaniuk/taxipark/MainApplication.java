package com.stepaniuk.taxipark;

import com.stepaniuk.taxipark.API.LogClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LogClass.logger.info("Start Application");
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Taxi Park");
        stage.setScene(scene);
        stage.getIcons().add(new Image(new File("src/main/resources/com/stepaniuk/taxipark/img/taxiIcon.png").toURI().toString()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}