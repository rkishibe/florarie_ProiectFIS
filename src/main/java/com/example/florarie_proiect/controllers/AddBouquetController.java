package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Document;

import java.io.IOException;

import static org.dizitart.no2.Document.createDocument;

public class AddBouquetController {
    @FXML
    private Text mesaj;
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
    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
       // Stage stage = (Stage) homeRoot.getScene().getWindow();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();


    }
    public void saveButton(ActionEvent e) throws IOException {
        // Bouquet bouquet=new Bouquet(nameField.getText(), Integer.parseInt(quantityField.getText()),Integer.parseInt(priceField.getText()));
        // create a document to populate data
        Document doc = createDocument("name",nameField.getText() )
                .put("quantity",Integer.parseInt(quantityField.getText()) )
                .put("price", Integer.parseInt(priceField.getText()));


        mesaj.setText("Bouquet added!");
        ///////////////adaug in baza de date buchettttttt
        BouquetService.loadBouquetsFromDatabase();
        BouquetService.addBouquet(doc);

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        // Stage stage = (Stage) homeRoot.getScene().getWindow();
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
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
