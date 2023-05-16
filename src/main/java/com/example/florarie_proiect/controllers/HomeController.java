package com.example.florarie_proiect.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToSceneLogin(ActionEvent event) throws IOException
    {
        try{
            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/login.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(homeRoot);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void switchToSceneRegister(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/register.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }


}
