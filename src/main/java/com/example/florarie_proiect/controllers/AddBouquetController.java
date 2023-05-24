package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.model.User;
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
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.dizitart.no2.Document.createDocument;
import static org.dizitart.no2.filters.Filters.eq;

public class AddBouquetController {
    @FXML
    public AnchorPane addPage;
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

    Stage stage;

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

    public void saveButton(ActionEvent e) throws IOException {
        BouquetService.loadBouquetsFromDatabase();
        Document doc;
        List<String> existingBouquets = new ArrayList<>();
        for (Document document : BouquetService.getFlowerCollection().find()) {
            String numeBuchet = document.get("name", String.class);
            existingBouquets.add(numeBuchet);
        }

        if (existingBouquets.contains(nameField.getText())) {
            mesaj.setText("Bouquet already exists!");
        } else {
            doc = createDocument("name", nameField.getText())
                    .put("quantity", Integer.parseInt(quantityField.getText()))
                    .put("price", Integer.parseInt(priceField.getText()));
            mesaj.setText("Bouquet added!");
            BouquetService.addBouquet(doc);
        }

        BouquetService.closeDatabase();

    }

}
