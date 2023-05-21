package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.exceptions.CouldNotWriteUsersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ModifyBouquetController {
    @FXML
    private Text mesaj;

    @FXML
    public void switchToSceneHome() throws IOException {

        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        Stage stage = (Stage) homeRoot.getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }
    public void saveButton(ActionEvent e) throws CouldNotWriteBouquetException {
        try{
            mesaj.setText("Bouquet modified!");
            TimeUnit.SECONDS.sleep(5);
            switchToSceneHome();
        }catch (CouldNotWriteBouquetException exception){
            exception.printStackTrace();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        ///////////////modific in baza de date buchettttttt
    }
}
