package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.util.Duration;

public class ModifyBouquetController {
    @FXML

    public TextField nameField;
    @FXML
    public TextField priceField;
    @FXML
    public TextField quantityField;
    @FXML

    private Text mesaj;

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
    public void saveButton(ActionEvent e) throws CouldNotWriteBouquetException {
        try{
            BouquetService.modifyBouquet(new Bouquet(nameField.getText(), Integer.parseInt(priceField.getText()), Integer.parseInt(quantityField.getText())));
            mesaj.setText("Bouquet modified!");
            delaySceneSwitch();

        }catch (CouldNotWriteBouquetException exception){
            exception.printStackTrace();
            throw new CouldNotWriteBouquetException();
        }
    }

    private void delaySceneSwitch() {
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> {
            try {
                switchToSceneHome(event);
            } catch (IOException e) {
                mesaj.setText("Error switching to home scene.");
            }
        });
        delay.play();
    }
}
