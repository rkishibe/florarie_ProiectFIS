package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginControllerTest  {

    private LoginController controller;
    private ActionEvent event;


    @BeforeEach
    public void setUp() throws Exception {
        event=new ActionEvent();
        FxToolkit.registerPrimaryStage();
        controller = new LoginController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.roleField = new ChoiceBox<>();
        controller.loginMessage=new Text();

    }

    @Test
    @DisplayName("Login as user")
    void testLoginInvalidUsername() throws IOException {
        controller.usernameField.setText("invalid");
        controller.passwordField.setText("invalid");
        controller.roleField.setValue("Admin");
        ActionEvent event = new ActionEvent();
        controller.handleLoginButtonAction(event);
       assertEquals(controller.getLoginMessage(), "Parola sau username gresite!");
    }

    @Test
    @DisplayName("Login as user")
    void testLoginValidUsername() throws IOException {
        controller.usernameField.setText("admin");
        controller.passwordField.setText("admin");
        controller.roleField.setValue("Admin");

        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");
        loginButton.getStyleClass().add("button");

        //ActionEvent event = new ActionEvent(loginButton, loginButton);
//
//        // Create a mock Scene and Window for the event source
//        Scene scene = new Scene(new Group());
//        Window window = new Stage();
//        scene.getWindow();
//        ((Node) event.getSource()).getScene();

        controller.handleLoginButtonAction(event);

        assertEquals(controller.getLoginMessage(), "Logat ca si admin.");
    }



}
