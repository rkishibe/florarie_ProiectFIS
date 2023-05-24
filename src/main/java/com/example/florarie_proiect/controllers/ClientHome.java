package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientHome {

    @FXML
    public void switchToSceneBouquetList(ActionEvent event) throws IOException {

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/BouquetList.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    public void switchToSceneHome(ActionEvent event) throws IOException {
        BouquetService.closeDatabase();
            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

    }
    @FXML
    public void switchToSceneCart(ActionEvent event) throws IOException {

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/cartPage.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();

    }

}
