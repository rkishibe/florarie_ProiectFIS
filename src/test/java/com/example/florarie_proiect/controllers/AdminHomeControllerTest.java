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

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class AdminHomeControllerTest {

   FxRobot robot;

    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @BeforeEach
    public  void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();

    }


    @Test
    public void testSwitchToSceneHome() {
        robot.clickOn("#homeButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Hello Admin"));
    }

    @Test
    public void testSwitchToSceneModify() {
        robot.clickOn("#modifyButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Add Bouquet"));
    }

    @Test
    public void testSwitchToSceneRemove() {
        robot.clickOn("#removeButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Choose the bouquet you want to remove"));
    }

    @Test
    public void testSwitchToSceneAdd() {
        robot.clickOn("#addButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Hello Admin"));
    }
}
