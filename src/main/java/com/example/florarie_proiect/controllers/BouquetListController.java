package com.example.florarie_proiect.controllers;


import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import org.dizitart.no2.FindOptions;

import java.io.IOException;


public class BouquetListController {

@FXML
ListView<String> buchete;

    @FXML
    private void addToCart(){

    }

    @FXML
    private void switchToSceneCart(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/cartPage.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void initialize() throws Exception {
        BouquetService.loadBouquetsFromDatabase();

        FindOptions findOptions = FindOptions.limit(0, 1);
        ObservableList<String> data = FXCollections.observableArrayList();  // Use String type for displaying names

        for (Document document : BouquetService.getFlowerCollection().find(findOptions)) {
            Bouquet bouquet = Bouquet.fromDocument(document);
            String bouquetName = bouquet.getName();  // Get the name of the bouquet
            data.add(bouquetName);
        }

        buchete.setItems(data);

        BouquetService.closeDatabase();
    }

}

