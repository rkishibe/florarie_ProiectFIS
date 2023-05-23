package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import static com.example.florarie_proiect.services.BouquetService.flowerCollection;

public class RemoveBouquetController {
    @FXML
    private Text mesaj;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    public void initialize() {
        if(flowerCollection!=null) {
            for (Document document : flowerCollection.find()) {
                String numeBuchet = document.get("name", String.class);
                choice.getItems().add(numeBuchet);
               // System.out.println(numeBuchet);
            }
        }

    }
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
        String numeBuchet = choice.getValue(); // Obține numele buchetului selectat din ChoiceBox
        BouquetService.removeBouquet(numeBuchet);
        BouquetService.closeDatabase();
    }
}
