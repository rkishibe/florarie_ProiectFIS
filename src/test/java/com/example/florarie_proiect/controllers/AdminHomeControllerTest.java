package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class AdminHomeControllerTest {

    private FxRobot robot;


    @BeforeEach
    public void setUp(){
        robot=new FxRobot();
    }

    @AfterEach
    public void setDown() throws Exception{
        BouquetService.closeDatabase();
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
