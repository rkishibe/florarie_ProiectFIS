
package com.example.florarie_proiect.controllers;
import com.example.florarie_proiect.model.Bouquet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
    private AnchorPane scenePane;

    Stage stage;

    public void handleSaveButton(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }

   /* @FXML
    public void handleSaveButton(ActionEvent event) throws IOException {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        int price=Integer.parseInt(priceField.getText());
        Bouquet bouquet = new Bouquet(name, quantity, price);

        Gson gson = new Gson();
        String json = gson.toJson(bouquet);

        try (FileWriter fileWriter = new FileWriter("bouquet.json")) {
            //fileWriter.write(json);
            fileWriter.append(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCancelButtonAction(ActionEvent event) throws IOException{

    }*/
}
