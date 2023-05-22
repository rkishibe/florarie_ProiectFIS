package com.example.florarie_proiect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Scene homeScene;

    @Override

    public void start(Stage primaryStage) {
        try {
            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
            Scene scene = new Scene(homeRoot);
            primaryStage.setScene(scene);
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
