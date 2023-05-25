package com.example.florarie_proiect.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException {
        // Încărcăm fișierul FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/florarie_proiect/cartPage.fxml"));
        Parent root = loader.load();
        OrderController controller = loader.getController();

        // Simulăm buchetele selectate pentru test
        List<String> selectedBouquets = Arrays.asList("Buchet 1", "Buchet 2");
        controller.getFlowerListView().getItems().addAll(selectedBouquets);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @BeforeEach
    void setUp() {
        BouquetService.loadBouquetsFromDatabase();
    }
    @AfterEach
    void tearDown(){
        BouquetService.closeDatabase();
    }

    @DisplayName(" Verificam ca lista de flori este populată corect")
    @Test
    void initialize(FxRobot robot) {
        ListView<String> flowerListView = robot.lookup("#flowerListView").queryListView();
        assertNotNull(flowerListView);
        ObservableList<String> actualItems = flowerListView.getItems();
        List<String> expectedItems = Arrays.asList("Buchet 1", "Buchet 2");
        assertEquals(expectedItems, actualItems);
    }

    @Test
    void switchToSceneClientHome(FxRobot robot) {
        robot.clickOn("#backButton");

        Node modifyPage = robot.lookup("#clientHome").query();
        assertNotNull(modifyPage);
        Scene scene =modifyPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/ClientHome.fxml", scene.getRoot().getId());

    }

    @Test
    void switchToSceneCart(FxRobot robot) {
        robot.clickOn("#finishButton");
        Node modifyPage = robot.lookup("#finishOrderPage").query();
        assertNotNull(modifyPage);
        Scene scene =modifyPage.getScene();
        assertNotNull(scene);
        assertEquals("/com/example/florarie_proiect/finishOrderPage.fxml", scene.getRoot().getId());

    }
