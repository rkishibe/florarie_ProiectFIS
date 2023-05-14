package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try{
            UserService.checkUserDoesNotAlreadyExist(usernameField.getText());
            if(UserService.checkPassword(usernameField.getText(), passwordField.getText(), usernameField.getText())){
                if(role.getValue()=="Client"){
                    loginMessage.setText("Logat ca si client.");
                } else if(role.getValue()=="Admin"){
                    loginMessage.setText("Logat ca si admin.");
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

    public void handleCancelButtonAction() {
        CancelController.initialize();
    }
}