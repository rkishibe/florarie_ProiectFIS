package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.BouquetNameFieldEmptyException;
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
import java.util.ArrayList;
import java.util.List;

import static org.dizitart.no2.Document.createDocument;

public class AddBouquetController {
    @FXML
    public AnchorPane addPage;
    @FXML
    public Text mesaj;
    @FXML
    public TextField nameField;

    @FXML
    public TextField priceField;

    @FXML
    public TextField quantityField;
    @FXML
    public Button saveButton;


    public void initialize() throws IOException {
        Parent root = FXMLLoader
                .load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/addBouquet.fxml"));

    }

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }
private String name;
    private int price, quantity;

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }


    public AddBouquetController() {
    }

    public String getMesaj() {
        return mesaj.getText();
    }

    public String getName() {
        return name;
    }

    public void saveButton() throws  BouquetNameFieldEmptyException {

        BouquetService.loadBouquetsFromDatabase();
        Document doc;
        List<String> existingBouquets = new ArrayList<>();
        for (Document document : BouquetService.getFlowerCollection().find()) {
            String numeBuchet = document.get("name", String.class);
            existingBouquets.add(numeBuchet);
        }
    try {
        //verific daca numele buchetului a fost introdus
         name = nameField.getText();
        }catch(BouquetNameFieldEmptyException exception) {
            mesaj.setText("Name field is empty!");

        }finally {
        //BouquetService.closeDatabase();
    }


        //verific daca cantitatea si pretul sunt intregi
        try {
            quantity = Integer.parseInt(quantityField.getText());
            price = Integer.parseInt(priceField.getText());
        } catch (NumberFormatException exception) {
            mesaj.setText("Quantity and price must be integers!");
        }finally {
          //  BouquetService.closeDatabase();
        }

        if (existingBouquets.contains(nameField.getText())) {
            mesaj.setText("Bouquet already exists!");
            BouquetService.closeDatabase();
        } else {
            doc = createDocument("name", nameField.getText())
                    .put("quantity", Integer.parseInt(quantityField.getText()))
                    .put("price", Integer.parseInt(priceField.getText()));
            mesaj.setText("Bouquet added!");
            BouquetService.addBouquet(doc);
        }



    }

}
