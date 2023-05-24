package com.example.florarie_proiect;

import com.example.florarie_proiect.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import static org.testfx.assertions.api.Assertions.assertThat;

class RegistrationTest {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    @BeforeEach
    void setUp()  {
        UserService.loadUsersFromDatabase();
    }
    @AfterAll
    static void tearDown() {
        UserService.closeDatabase();
    }

    @Test
    void testRegistration(FxRobot robot) {
        robot.clickOn("#username");
        robot.write(USERNAME);
        robot.clickOn("#password");
        robot.write(PASSWORD);
        robot.clickOn("#registerButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Cont creat cu succes!");
        assertThat(UserService.getUsers()).size().isEqualTo(1);

        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(
                String.format("An account with the username %s already exists!", USERNAME));

        robot.clickOn("#username");
        robot.write("1");
        robot.clickOn("#password");
        robot.write(PASSWORD);
        robot.clickOn("#registerButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Cont creat cu succes!");
        assertThat(UserService.getUsers()).size().isEqualTo(2);
    }

}

