package com.example.florarie_proiect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
