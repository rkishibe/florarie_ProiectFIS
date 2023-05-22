package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveBouquetController {
    @FXML
    private Text mesaj;
    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) homeRoot.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }
    public void okButton(ActionEvent e) {
        mesaj.setText("Bouquet removed!");
        ///////////////sterg din baza de date buchettttttt
    }
}
