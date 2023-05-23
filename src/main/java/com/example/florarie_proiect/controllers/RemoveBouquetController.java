package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Document;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.io.IOException;

public class RemoveBouquetController {
    @FXML
    private Text mesaj;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    public void initialize() {
        BouquetService.loadBouquetsFromDatabase();
        if(BouquetService.getFlowerCollection()!=null) {
            for (Document document : BouquetService.getFlowerCollection().find()) {
                String numeBuchet = document.get("name", String.class);
                System.out.println(numeBuchet);
                choice.getItems().add(numeBuchet);
                // System.out.println(numeBuchet);
            }
        }
        else {
            System.out.println("baza de date goala");
        }

    }
    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
        BouquetService.closeDatabase();
    }
    public void okButton(ActionEvent e) {
        mesaj.setText("Bouquet removed!");
        //sterg din baza de date buchettttttt
        String numeBuchet = choice.getValue(); // Obține numele buchetului selectat din ChoiceBox
        BouquetService.removeBouquet(numeBuchet);
        BouquetService.closeDatabase();
    }
}
