package com.example.florarie_proiect.controllers;

import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminHomeControllerTest {
    private AdminHome controller;
    private FxRobot robot;
    @BeforeEach
    void setUp() throws IOException {
//        primaryStage=new Stage();
//        Parent root = FXMLLoader
//                .load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
//        primaryStage.setTitle("ADD BOUQUET Example");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        controller=new AdminHome();
        robot=new FxRobot();
        controller.initialize();
    }


    @Test
    public void testSwitchToSceneHome() {
        robot.clickOn("#homeButton");

        Node homePage = robot.lookup("#adminHome").query();
        assertNotNull(homePage);
        Scene scene = homePage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/AdminHome.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneModify() {
        robot.clickOn("#modifyButton");

        Node modifyPage = robot.lookup("#modifyPage").query();
        assertNotNull(modifyPage);
        Scene scene = modifyPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/modifyBouquet.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneRemove() {
        robot.clickOn("#removeButton");

        Node removePage = robot.lookup("#removePage").query();
        assertNotNull(removePage);
        Scene scene = removePage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/RemoveBouquet.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneAdd() {
        robot.clickOn("#addButton");

        Node addPage = robot.lookup("#addPage").query();
        assertNotNull(addPage);
        Scene scene = addPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/addBouquet.fxml", scene.getRoot().getId());
    }
}
