package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DetaliiComandaController {
@FXML
private TableView<Bouquet> table;

@FXML
private TableColumn<Bouquet,String> name;
    @FXML
    private TableColumn<Bouquet, Integer> price;
    @FXML
    private TableColumn<Bouquet,Integer> quantity;

    @FXML
    private TextField total;

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }
    /*
    ObservableList<Bouquet> initialData(){
        for (Bouquet element :BouquetListController.getSelectedBouquets() ) {
            FXCollections.<Bouquet>observableArrayList(element);
        }
        BouquetService.closeDatabase();
        return FXCollections.<Bouquet>observableArrayList();
    }*/

    ObservableList<Bouquet> initialData() {
        ObservableList<Bouquet> data = FXCollections.observableArrayList();
        data.addAll(BouquetListController.getSelectedBouquets());
        BouquetService.closeDatabase();
        return data;
    }


    @FXML
    public void initialize(){
        name.setCellValueFactory(new PropertyValueFactory<Bouquet, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Bouquet, Integer>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<Bouquet, Integer>("quantity"));

        Bouquet bouquet=new Bouquet();
        table.setItems(initialData());

        //calculez suma totala
        int sum=0;
        for (Bouquet element :BouquetListController.getSelectedBouquets() ) {
            sum=sum+ element.getPrice()* element.getQuantity();
        }
        String aux = "" + sum;
        total.setText(aux);
    }


}
