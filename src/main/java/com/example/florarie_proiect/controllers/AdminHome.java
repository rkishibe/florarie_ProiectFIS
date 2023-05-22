package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHome  implements Initializable {

        @FXML
        public void switchToSceneModify(ActionEvent event) throws IOException {

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/modifyBouquet.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

        }

        @FXML
        public void switchToSceneHome(ActionEvent event) throws IOException {

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

        }
        @FXML
        public void switchToSceneRemove(ActionEvent event) throws IOException {

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/RemoveBouquet.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

        }

    @FXML
    public void switchToSceneAdd(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/addBouquet.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
    }

