package com.example.florarie_proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminHome {
    @FXML
    private Button modifyButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button homeButton;
    @FXML
    private void redirectToModify() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/modifyBouquet.fxml"));
            Stage stage = (Stage) modifyButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void redirectToRemove() throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/remove.fxml"));
        Stage stage = (Stage)removeButton.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void redirectToHome() throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
        Stage stage = (Stage)homeButton.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }


}
