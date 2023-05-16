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
    public void start(Stage primaryStage) {
        try {
            Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
            homeScene = new Scene(homeRoot);
            primaryStage.setResizable(false);
            primaryStage.setScene(homeScene);
            primaryStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);

    }

}
