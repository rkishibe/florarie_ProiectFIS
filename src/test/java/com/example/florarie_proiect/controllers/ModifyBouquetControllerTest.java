package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.Main;
import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class ModifyBouquetControllerTest {

    FxRobot robot;

    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/AdminHome.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @BeforeEach
    void setUp() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
    }

    @Test
    public void testSwitchToSceneHome() {
        robot.clickOn("#homeButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Hello Admin"));
    }

    @Test
    void saveButton_success(){
        robot.clickOn("#nameField");
        robot.write("hortensii");
        robot.clickOn("#priceField");
        robot.write("12");
        robot.clickOn("#quantityField");
        robot.write("1");

        robot.clickOn("#saveButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Bouquet modified!"));

    }

    @Test
    void saveButton_exceptionThrown() {
        assertThrows(CouldNotWriteBouquetException.class, () -> {});
    }
}
