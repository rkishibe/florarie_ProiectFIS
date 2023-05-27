package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.concurrent.TimeoutException;

import static org.testfx.assertions.api.Assertions.assertThat;
@ExtendWith(ApplicationExtension.class)
public class RegistrationControllerTest  {

    private FxRobot robot;
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";


    @BeforeEach
    void setUp() throws TimeoutException {
        UserService.loadUsersFromDatabase();
        FxToolkit.registerPrimaryStage();
        robot = new FxRobot();
    }

    @AfterAll
    static void tearDown() {
        UserService.closeDatabase();
    }

    @Test
    void testRegistration() {
        robot.clickOn("#usernameField").write(USERNAME);

        robot.clickOn("#passwordField").write(PASSWORD);
        robot.clickOn("#registerButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Cont creat cu succes!");
        assertThat(UserService.getUsers()).size().isEqualTo(1);

        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(
                String.format("An account with the username %s already exists!", USERNAME));

        robot.clickOn("#usernameField").write("1");
        robot.clickOn("#passwordField").write(PASSWORD);
        robot.clickOn("#registerButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Cont creat cu succes!");
        assertThat(UserService.getUsers()).size().isEqualTo(2);
    }
}
