
package com.example.florarie_proiect.controller;
import com.example.florarie_proiect.model.Bouquet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;

public class SaveController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField quantityField;
    @FXML
    private Button saveButton;

    @FXML
    public void handleSaveButton(ActionEvent event) throws IOException {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        int price=Integer.parseInt(priceField.getText());
        Bouquet bouquet = new Bouquet(name, quantity, price);

        Gson gson = new Gson();
        String json = gson.toJson(bouquet);

        try (FileWriter fileWriter = new FileWriter("bouquet.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
