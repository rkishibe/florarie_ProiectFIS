package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.UsernameAlreadyExistsException;
import com.example.florarie_proiect.services.UserService;
import javafx.scene.Node;
import javafx.scene.Scene;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;

public class LoginControllerTest {

    public static final String USERNAME_CLIENT = "cl";
    public static final String PASSWORD_CLIENT = "pass";
    public static final String USERNAME_ADMIN = "ad";
    public static final String PASSWORD_ADMIN = "pass";
    public static final String ROLE_CLIENT = "Client";
    public static final String ROLE_ADMIN = "Client";

    @BeforeEach
    void setUp() throws UsernameAlreadyExistsException {
        UserService.loadUsersFromDatabase();
        UserService.addUser(USERNAME_CLIENT, PASSWORD_CLIENT, ROLE_CLIENT);
        UserService.addUser(USERNAME_ADMIN, PASSWORD_ADMIN, ROLE_ADMIN);
    }
    @AfterAll
    static void tearDown() {
        UserService.closeDatabase();
    }

    @Test
    void succesLoginClientTest(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write(USERNAME_CLIENT);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD_CLIENT);
        robot.clickOn("#roleField");
        robot.clickOn("Client");

        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginMessage").queryText()).hasText("Logat ca si client.");
        Assertions.assertThat(UserService.getUsers()).size().isEqualTo(1);

    }

    @Test
    void failLoginWrongTest(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write("abc");
        robot.clickOn("#passwordField");
        robot.write("bca");
        robot.clickOn("#roleField");
        robot.clickOn("Client");

        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginMessage").queryText()).hasText("Parola sau username gresite!");
        Assertions.assertThat(UserService.getUsers()).size().isEqualTo(0);

    }

    @Test
    void failLoginEmptyTest(FxRobot robot) {
        robot.clickOn("#usernameField");
        //robot.write("abc");
        robot.clickOn("#passwordField");
        robot.write("bca");
        robot.clickOn("#roleField");
        robot.clickOn("Client");

        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginMessage").queryText()).hasText("Parola sau username gresite!");

        robot.clickOn("#usernameField");
        robot.write("abc");
        robot.clickOn("#passwordField");
        //robot.write("bca");
        robot.clickOn("#roleField");
        robot.clickOn("Client");

        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginMessage").queryText()).hasText("Parola sau username gresite!");

        Assertions.assertThat(UserService.getUsers()).size().isEqualTo(0);

    }

    @Test
    void switchToSceneHome(FxRobot robot) throws IOException {
        robot.clickOn("#homeButton");

        // Verify that the scene is switched to the home page
        Node modifyPage = robot.lookup("#AdminHome").query();
        assertNotNull(modifyPage);
        Scene scene =modifyPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/AdminHome.fxml", scene.getRoot().getId());
    }

}
