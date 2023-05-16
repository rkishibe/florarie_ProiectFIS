package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.UserService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    private ChoiceBox role;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }
    @FXML
    public void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try{
            UserService.checkUserDoesNotAlreadyExist(usernameField.getText());
            if(UserService.checkPassword(usernameField.getText(), passwordField.getText(), usernameField.getText())){
                if(role.getValue()=="Client"){
                    loginMessage.setText("Logat ca si client.");
                    Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(homeRoot);
                    stage.setScene(scene);
                    stage.show();
                } else if(role.getValue()=="Admin"){
                    loginMessage.setText("Logat ca si admin.");
                    Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(homeRoot);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }catch (Exception e){

        }


        if (username == null || username.isEmpty()) {
            loginMessage.setText("Tastati un username!");
            return;
        }
        if (password == null || password.isEmpty()) {
            loginMessage.setText("Tastati o parola!");
            return;
        }

        loginMessage.setText("Parola sau username gresite!");
    }

/*
    public void handleCancelButtonAction(ActionEvent event) throws Exception {
        // Get the current scene
        Scene currentScene = ((Node) event.getSource()).getScene();

        // Get the previous scene from the user data of the current scene
        Scene previousScene = (Scene) currentScene.getUserData();

        if (previousScene == null) {
            // If there is no previous scene, just close the current window
            Stage stage = (Stage) currentScene.getWindow();
            stage.close();
        } else {
            // Set the previous scene as the current scene
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(previousScene);
            stage.show();
        }

    }*/

    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
}