package com.example.florarie_proiect.test;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.event.ActionEvent;
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
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ModifyBouquetControllerTest {

    private TextField nameField;
    private TextField priceField;
    private TextField quantityField;
    private Text mesaj;

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
    void saveButton_success(){

    }

    @Test
    void saveButton_exceptionThrown() {
        assertThrows(CouldNotWriteBouquetException.class, () -> {});
    }
}
