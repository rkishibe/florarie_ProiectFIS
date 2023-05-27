package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class LoginControllerTest  {

    FxRobot robot;

    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Test
    @DisplayName("Login as user")
    void testLoginInvalidUsername() throws IOException {
        robot.clickOn("usernameField");
        robot.write("aaa");
        robot.clickOn("passwordField");
        robot.write("aaa");
        robot.clickOn("roleField");
        robot.clickOn("Admin");
        robot.clickOn("#loginButton");


        verifyThat("#loginMessage", LabeledMatchers.hasText("Parola sau username gresite!"));
    }

    @Test
    @DisplayName("Login as client user")
    void testLoginValidClientUsername() throws IOException {
        robot.clickOn("usernameField");
        robot.write("a");
        robot.clickOn("passwordField");
        robot.write("a");
        robot.clickOn("roleField");
        robot.clickOn("Client");
        robot.clickOn("#loginButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Hello Client"));
    }

    @Test
    @DisplayName("Login as admin user")
    void testLoginValidAdminUsername() throws IOException {
        robot.clickOn("usernameField");
        robot.write("a");
        robot.clickOn("passwordField");
        robot.write("a");
        robot.clickOn("roleField");
        robot.clickOn("Admin");
        robot.clickOn("#loginButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("hello Admin"));
    }

}
