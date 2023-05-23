package com.example.florarie_proiect.controllers;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController {
    @FXML
    private ListView<String> flowerListView;



    public void initialize() {
        for (Bouquet element :BouquetListController.getSelectedBouquets() ) {
            flowerListView.getItems().add(element.getName());
        }
        BouquetService.closeDatabase();
    }

/*
    public void getAllFlowers() {
       Cursor<Bouquet> cursor = flowerRepository.find();
        List<Bouquet> flowers = new ArrayList<>();
        for (Bouquet flower : cursor) {
            flowers.add(flower);
        }

        return flowers;
        List<String> flowerListView = new ArrayList<>();
    }*/

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle){
//        flowerListView.setCellFactory(param -> new ListCell<Bouquet>() {
//            @Override
//            protected void updateItem(Bouquet item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if (empty || item == null || item.getWord() == null) {
//                    setText(null);
//                } else {
//                    setText(item.getWord());
//                }
//            }
//        });
//    }


    public void switchToSceneClientHome(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
        Stage stage = (Stage) homeRoot.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
}


