package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button registerButton;
@FXML
private Button loginButton;
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


    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> redirectToLogin());
        registerButton.setOnAction(event -> redirectToRegister());
    }

    @FXML
    private void redirectToLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/login.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void redirectToRegister() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/register.fxml"));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
