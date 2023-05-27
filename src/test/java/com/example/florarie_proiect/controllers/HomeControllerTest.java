package com.example.florarie_proiect.controllers;

import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class HomeControllerTest {
    private FxRobot robot;
    @BeforeEach
    void setUp() throws TimeoutException {
        robot=new FxRobot();
        FxToolkit.registerPrimaryStage();
    }

    @Test
    public void testSwitchToSceneLogin() {
        robot.clickOn("#loginButton");

        Node loginPage = robot.lookup("#loginPage").query();
        assertNotNull(loginPage);
        Scene scene = loginPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/login.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneRegister() {
        robot.clickOn("#registerButton");

        Node registerPage = robot.lookup("#registerPage").query();
        assertNotNull(registerPage);
        Scene scene = registerPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/register.fxml", scene.getRoot().getId());
    }
}
