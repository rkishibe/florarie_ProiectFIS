package com.example.florarie_proiect.controllers;

import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class AdminHomeControllerTest {
    @Test
    public void testSwitchToSceneHome(FxRobot robot) {
        robot.clickOn("#homeButton");

        Node homePage = robot.lookup("#adminHome").query();
        assertNotNull(homePage);
        Scene scene = homePage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/AdminHome.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneModify(FxRobot robot) {
        robot.clickOn("#modifyButton");

        Node modifyPage = robot.lookup("#modifyPage").query();
        assertNotNull(modifyPage);
        Scene scene = modifyPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/modifyBouquet.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneRemove(FxRobot robot) {
        robot.clickOn("#removeButton");

        Node removePage = robot.lookup("#removePage").query();
        assertNotNull(removePage);
        Scene scene = removePage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/RemoveBouquet.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneAdd(FxRobot robot) {
        robot.clickOn("#addButton");

        Node addPage = robot.lookup("#addPage").query();
        assertNotNull(addPage);
        Scene scene = addPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/addBouquet.fxml", scene.getRoot().getId());
    }
}
