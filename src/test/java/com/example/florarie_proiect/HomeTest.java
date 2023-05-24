package com.example.florarie_proiect;

import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class HomeTest {
    @Test
    public void testSwitchToSceneLogin(FxRobot robot) {
        robot.clickOn("#loginButton");

        Node loginPage = robot.lookup("#loginPage").query();
        assertNotNull(loginPage);
        Scene scene = loginPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/login.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneRegister(FxRobot robot) {
        robot.clickOn("#registerButton");

        Node registerPage = robot.lookup("#registerPage").query();
        assertNotNull(registerPage);
        Scene scene = registerPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/register.fxml", scene.getRoot().getId());
    }
}
