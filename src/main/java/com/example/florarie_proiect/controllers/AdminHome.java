package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHome {

//    public void initialize() throws IOException {
//        Parent root = FXMLLoader
//                .load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
//
//    }
    @FXML
        public void switchToSceneHome(ActionEvent event) throws IOException {
            BouquetService.closeDatabase();
            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

        }
        @FXML
        public void switchToSceneModify(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/modifyBouquet.fxml"));
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

    }

