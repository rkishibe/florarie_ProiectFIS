package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
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

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class BouquetListControllerTest{
    Text mesaj;
    FxRobot robot;
    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/BouquetList.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @BeforeEach
    public  void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();

    }

    @Test
    public void testAddToCart() {
        robot.clickOn("#addCartButton");
        assertThat(robot.lookup(mesaj.getText()).queryText()).hasText("Bouquet added to cart!");
    }

    @Test
    public void testSwitchToSceneCart() throws TimeoutException {
        robot.clickOn("#cartButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Your cart"));
    }

    @Test
    public void testSwitchToSceneHome() {
        robot.clickOn("#homeButton");
        verifyThat("#PageTitle", LabeledMatchers.hasText("Welcome to our flower shop!"));
    }


}
