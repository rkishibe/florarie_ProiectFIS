package com.example.florarie_proiect;

import com.example.florarie_proiect.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Scene homeScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent homeRoot = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
        primaryStage.setScene(new Scene(homeRoot, 300, 275));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
