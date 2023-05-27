package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class ModifyBouquetControllerTest {
    private ModifyBouquetController controller;
    private FxRobot robot;

    @BeforeEach
    void setUp() throws TimeoutException {
        //BouquetService.loadBouquetsFromDatabase();
        FxToolkit.registerPrimaryStage();
        controller = new ModifyBouquetController();
        controller.nameField = new TextField();
        controller.priceField = new TextField();
        controller.quantityField = new TextField();
        controller.choice = new ChoiceBox<>();
        controller.mesaj=new Text();
        controller.initialize();
        robot=new FxRobot();
//        Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/BouquetList.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    @Test
    void switchToSceneHome() throws IOException {
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
        controller.nameField.setText("hortensii");
        controller.priceField.setText("12");
        controller.quantityField.setText("1");
        controller.saveButton();

        assertEquals(controller.getLoginMessage(),"Bouquet modified!");
    }

    @Test
    void saveButton_exceptionThrown() {
        assertThrows(CouldNotWriteBouquetException.class, () -> {});
    }
}
