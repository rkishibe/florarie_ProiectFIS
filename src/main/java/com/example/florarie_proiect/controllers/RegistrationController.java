package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExists;
import com.example.florarie_proiect.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Cont creat cu succes!");
        } catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}