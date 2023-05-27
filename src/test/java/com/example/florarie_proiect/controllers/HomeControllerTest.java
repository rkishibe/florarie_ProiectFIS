package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class HomeControllerTest {
    FxRobot robot;
    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/home.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @BeforeEach
    void setUp() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
    }

    @Test
    public void testSwitchToSceneLogin() {
        robot.clickOn("#loginButton");
        verifyThat("#title-text", LabeledMatchers.hasText("Flower shop login"));
    }

    @Test
    public void testSwitchToSceneRegister() {
        robot.clickOn("#registerButton");
        verifyThat("#title-text", LabeledMatchers.hasText("Flower shop register"));
    }
}
