package com.example.florarie_proiect.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class BouquetListControllerTest {

    @BeforeEach
    public void setUp(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/BouquetList.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testAddToCart(FxRobot robot) {
        robot.clickOn("#choice");
        robot.clickOn(""); //robot clicks on a bouquet name

        robot.clickOn("#addCartButton");
        assertThat(robot.lookup("#loginMessage").queryText()).hasText("Bouquet added to cart!");
    }

    @Test
    public void testSwitchToSceneCart(FxRobot robot) throws TimeoutException {
        robot.clickOn("#cartButton");

        // Verify that the scene is switched to the cart page
        Node cartPage = robot.lookup("#cartPage").query();
        assertNotNull(cartPage);
        Scene scene = cartPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/cartPage.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneHome(FxRobot robot) {
        robot.clickOn("#homeButton");

        // Verify that the scene is switched to the home page
        Node cartPage = robot.lookup("#clientHome").query();
        assertNotNull(cartPage);
        Scene scene = cartPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/ClientHome.fxml", scene.getRoot().getId());
    }

    @Test
    public void testInitializeWithFlowerCollection() {
        // TODO: Implement test for initialize() method when FlowerCollection is not null
    }

    @Test
    public void testInitializeWithEmptyFlowerCollection() {
        // TODO: Implement test for initialize() method when FlowerCollection is null
    }
}