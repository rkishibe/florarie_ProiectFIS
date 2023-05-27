package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Document;

import java.io.IOException;

public class ModifyBouquetController {

    @FXML
    ChoiceBox<String> choice;

    @FXML
    public TextField nameField;
    @FXML
    public TextField priceField;
    @FXML
    public TextField quantityField;
    @FXML
    Text mesaj;

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

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
    public void saveButton() throws CouldNotWriteBouquetException {
        String selectedBouquet = choice.getSelectionModel().getSelectedItem();
        try {
            Bouquet modifiedBouquet = new Bouquet(nameField.getText(), Integer.parseInt(priceField.getText()), Integer.parseInt(quantityField.getText()));
            BouquetService.modifyBouquet(selectedBouquet, modifiedBouquet);
            mesaj.setText("Bouquet modified!");
        } catch (CouldNotWriteBouquetException exception) {
            exception.printStackTrace();
            throw new CouldNotWriteBouquetException();
        }
        finally {
            BouquetService.closeDatabase();
        }
    }

    public String getLoginMessage() {
        return mesaj.getText();
    }
}
