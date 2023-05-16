package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
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
            UserService.loadUsersFromFile();
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Cont creat cu succes!");
        } catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    }
    */
public void switchToSceneHome(ActionEvent event) throws IOException
{
    Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(homeRoot);
    stage.setScene(scene);
    stage.show();
}


}