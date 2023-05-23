package com.example.florarie_proiect.controllers;


import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.dizitart.no2.Document;

import java.io.IOException;


public class BouquetListController {

    @FXML
    ChoiceBox<String> choice;
    @FXML
    private void addToCart(){
    }

    @FXML
    void switchToSceneCart(ActionEvent event) throws IOException {
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
    public void initialize() {
        BouquetService.loadBouquetsFromDatabase();
        if(BouquetService.getFlowerCollection()!=null) {
            for (Document document : BouquetService.getFlowerCollection().find()) {
                String numeBuchet = document.get("name", String.class);
                choice.getItems().add(numeBuchet);
            }
        }
        else {
            System.out.println("baza de date goala");
        }

    }

}

