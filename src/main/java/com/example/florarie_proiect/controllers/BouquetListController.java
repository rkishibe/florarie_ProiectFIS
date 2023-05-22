package com.example.florarie_proiect.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class BouquetListController implements Initializable {
    @FXML
    private ListView<String> buchete;
    String[] buchet={"trandafiri", "lalele", "crini"};
    String curentBuchet;
    @FXML
    private Label myLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buchete.getItems().addAll(buchet);
        buchete.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                curentBuchet=buchete.getSelectionModel().getSelectedItem();
                myLabel.setText(curentBuchet);
                // aici va trebui sa salvam in baza de date alegerea facuta
            }
        });
    }
}
