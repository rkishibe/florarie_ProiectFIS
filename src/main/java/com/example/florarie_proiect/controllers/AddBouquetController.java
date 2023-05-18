package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.model.Bouquet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;

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
        Stage stage = (Stage) homeRoot.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private TextField numeField;
    @FXML
    private TextField pretField;
    @FXML
    private TextField cantitateField;

    private Nitrite db;
    private ObjectRepository<Bouquet> repository;

    public void initialize() {
        // Deschide sau creează baza de date Nitrite
        db = Nitrite.builder()
                .compressed()
                .filePath("baza_de_date.db")
                .openOrCreate();

        // Obține repository pentru clasa Buchet
        repository = db.getRepository(Bouquet.class);
    }

    @FXML
    public void saveButton(ActionEvent e) {
        mesaj.setText("Bouquet added!");
        ///////////////adaug in baza de date buchettttttt

        String nume = numeField.getText();
        int pret = Integer.parseInt(pretField.getText());
        int cantitate = Integer.parseInt(cantitateField.getText());

        Bouquet buchet = new Bouquet(nume, cantitate, pret);
        repository.insert(buchet);

        // Închide baza de date
        db.close();


    }
    
}
