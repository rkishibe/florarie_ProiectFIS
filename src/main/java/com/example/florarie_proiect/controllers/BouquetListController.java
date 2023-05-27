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
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.dizitart.no2.filters.Filters.eq;


public class BouquetListController {
    private static List<Bouquet> selectedBouquets=new ArrayList<>();
    public Button addCartButton;
    public Button cartButton;
    @FXML
    ChoiceBox<String> choice;
    @FXML
    private Text mesaj;



    public Button getAddCartButton() {
        return addCartButton;
    }

    public Button getCartButton() {
        return cartButton;
    }

    public ChoiceBox<String> getChoice() {
        return choice;
    }

    public Text getMesaj() {
        return mesaj;
    }

    @FXML
    void switchToSceneCart(ActionEvent event) throws IOException {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/cartPage.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }

    public static List<Bouquet> getSelectedBouquets() {
        return selectedBouquets;
    }

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public String initialize() {
        BouquetService.loadBouquetsFromDatabase();
        if(BouquetService.getFlowerCollection()!=null) {
            for (Document document : BouquetService.getFlowerCollection().find()) {
                String numeBuchet = document.get("name", String.class);
                choice.getItems().add(numeBuchet);
                return null;
            }
        }
        else {

            return "baza de date goala";
        }

        return null;
    }
    @FXML
    public void addToCart(){
        if (BouquetService.getFlowerCollection() != null) {
            String numeBuchet = choice.getValue(); // Obține numele buchetului selectat din ChoiceBox
            Document existingBouquet = BouquetService.getFlowerCollection().find(eq("name", numeBuchet)).firstOrDefault();
           // for (Document document : BouquetService.getFlowerCollection().find() {
                if(existingBouquet!=null)
                {
                    Bouquet bouquet=new Bouquet((String)existingBouquet.get("name"), (Integer) existingBouquet.get("quantity"), (Integer)existingBouquet.get("price"));
                selectedBouquets.add(bouquet);
              //  System.out.println(numeBuchet);
            }
        } else {
            System.out.println("baza de date goala");
        }
        mesaj.setText("Bouquet added to cart!");

    }

}

