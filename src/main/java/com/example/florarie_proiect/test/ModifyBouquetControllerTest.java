package com.example.florarie_proiect.test;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;


class ModifyBouquetControllerTest {

    @BeforeEach
    void setUp(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/BouquetList.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    @Test
    void saveButton_success(FxRobot robot){
        robot.clickOn("nameField");
        robot.write("trandafiri");
        robot.clickOn("priceField");
        robot.write("1");
        robot.clickOn("quantityField");
        robot.write("10");
        robot.clickOn("saveButton");

        assertThat(robot.lookup("mesaj").queryText()).hasText("Bouquet modified!");
    }

    @Test
    void saveButton_exceptionThrown() {
        assertThrows(CouldNotWriteBouquetException.class, () -> {});
    }
}
