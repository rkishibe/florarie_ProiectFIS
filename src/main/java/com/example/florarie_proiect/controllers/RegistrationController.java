package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
import com.example.florarie_proiect.services.UserService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.loadUsersFromDatabase();
           UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Cont creat cu succes!");
            UserService.closeDatabase();
        } catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }


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
    }

}