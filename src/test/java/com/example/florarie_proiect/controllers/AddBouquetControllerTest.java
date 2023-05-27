package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.services.BouquetService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddBouquetControllerTest extends ApplicationTest {
        public static final String NAME = "numeBuchet";
        public static final String PRET = "100";
        public static final String CANTITATE = "23";

        private FxRobot robot;

        @Start
        public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/addBouquet.fxml"));
                primaryStage.setTitle("ADD BOUQUET Example");
                primaryStage.setScene(new Scene(root, 300, 275));
                primaryStage.show();
        }
        @BeforeEach
        public void setUp() throws Exception {
                robot=new FxRobot();
                BouquetService.loadBouquetsFromDatabase();
        }
        @AfterEach
        public void setDown() throws Exception{
                BouquetService.closeDatabase();
        }

        @DisplayName("Test pentru schimbarea scenei de la cea de addBouquet la cea de adminHome")
        @Test
        void switchToSceneHome(FxRobot robot) {
                robot.clickOn("#cancelButton");

                Node homePage = robot.lookup("#adminHome").query();
                assertNotNull(homePage);
                Scene scene = homePage.getScene();
                assertNotNull(scene);
                assertEquals("/com/example/florarie_proiect/AdminHome.fxml", scene.getRoot().getId());
        }


        @DisplayName("Test pt adaugarea unui buchet")
        @Test
        public void testAddOK() throws IOException {
                // Setarea imputurilor
                robot.clickOn("#nameField");
                robot.write(NAME);
                robot.clickOn("#priceField");
                robot.write(PRET);
                robot.clickOn("#quantityField");
                robot.write(CANTITATE);

                robot.clickOn("#saveButton");
                // Verificam message text-ul
                assertEquals(robot.lookup("#mesaj").queryText(), "Bouquet added!");

        }

        @DisplayName("Test pt adaugarea unui buchet deja existent")
        @Test
        public void testAddExist() throws IOException {
                // Setarea imputurilor
                robot.clickOn("#nameField");
                robot.write(NAME);
                robot.clickOn("#priceField");
                robot.write(PRET);
                robot.clickOn("#quantityField");
                robot.write(CANTITATE);

                robot.clickOn("#saveButton");
                assertEquals(robot.lookup("#mesaj").queryText(), "Bouquet already exists!");


        }
}