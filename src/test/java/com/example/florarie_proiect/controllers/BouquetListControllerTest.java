package com.example.florarie_proiect.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class BouquetListControllerTest{
    private BouquetListController controller;
    private FxRobot robot;

    @FXML
    public Button addCartButton;
    @FXML
    public Button cartButton;
    @FXML
    ChoiceBox<String> choice;
    @FXML
    private Text mesaj;

    @BeforeEach
    public void setUp() throws IOException {
        controller=new BouquetListController();

//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/BouquetList.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();
        robot=new FxRobot();
    }

    @Test
    public void testAddToCart() {
        robot.clickOn(controller.getChoice());
        robot.clickOn(choice.getValue()); //robot clicks on a bouquet name

        robot.clickOn(addCartButton);
        assertThat(robot.lookup(mesaj.getText()).queryText()).hasText("Bouquet added to cart!");
    }

    @Test
    public void testSwitchToSceneCart() throws TimeoutException {
        robot.clickOn(controller.getCartButton());

        // Verify that the scene is switched to the cart page
        Node cartPage = robot.lookup("#cartPage").query();
        assertNotNull(cartPage);
        Scene scene = cartPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/cartPage.fxml", scene.getRoot().getId());
    }

    @Test
    public void testSwitchToSceneHome() {
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
        assertNull(controller.initialize());
    }

    @Test
    public void testInitializeWithEmptyFlowerCollection() {
        assertEquals(controller.initialize(), "baza de date goala");
    }

}
