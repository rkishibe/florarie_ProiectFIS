package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.controllers.AddBouquetController;
import com.example.florarie_proiect.exceptions.BouquetNameFieldEmptyException;
import com.example.florarie_proiect.services.BouquetService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.dizitart.no2.Document;
import org.junit.jupiter.api.*;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddBouquetControllerTest {
    public static final String NAME = "numeBuchet";
    public static final String PRET = "100";
    public static final String CANTITATE = "23";

    private FxRobot robot;
    /*
        @Start
        void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader
                    .load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/addBouquet.fxml"));
            primaryStage.setTitle("ADD BOUQUET Example");
            primaryStage.setScene(new Scene(root, 300, 275));
            primyStage.show();
        }

        /*
         * @BeforeEach
         * public void setUp() throws Exception {
         * robot=new FxRobot();
         * BouquetService.loadBouquetsFromDatabase();
         * }
         *
         * @AfterEach
         * public void setDown() throws Exception{
         * BouquetService.closeDatabase();
         * }
         *
         * @DisplayName("Test pentru schimbarea scenei de la cea de addBouquet la cea de adminHome"
         * )
         *
         * @Test
         * void switchToSceneHome(FxRobot robot) {
         * robot.clickOn("#cancelButton");
         *
         * Node homePage = robot.lookup("#adminHome").query();
         * assertNotNull(homePage);
         * Scene scene = homePage.getScene();
         * assertNotNull(scene);
         * assertEquals("/com/example/florarie_proiect/AdminHome.fxml",
         * scene.getRoot().getId());
         * }
         *
         *
         * @DisplayName("Test pt adaugarea unui buchet")
         *
         * @Test
         * public void testAddOK() throws IOException {
         * // Setarea imputurilor
         * robot.clickOn("#nameField");
         * robot.write(NAME);
         * robot.clickOn("#priceField");
         * robot.write(PRET);
         * robot.clickOn("#quantityField");
         * robot.write(CANTITATE);
         *
         * robot.clickOn("#saveButton");
         * // Verificam message text-ul
         * assertEquals(robot.lookup("#mesaj").queryText(), "Bouquet added!");
         *
         * }
         *
         * @DisplayName("Test pt adaugarea unui buchet deja existent")
         *
         * @Test
         * public void testAddExist() throws IOException {
         * // Setarea imputurilor
         * robot.clickOn("#nameField");
         * robot.write(NAME);
         * robot.clickOn("#priceField");
         * robot.write(PRET);
         * robot.clickOn("#quantityField");
         * robot.write(CANTITATE);
         *
         * robot.clickOn("#saveButton");
         * assertEquals(robot.lookup("#mesaj").queryText(), "Bouquet already exists!");
         *
         *
         * }
         *
         */
    private AddBouquetController controller;

    @BeforeEach
    public  void setUp() throws Exception {

        FxToolkit.registerPrimaryStage();
        controller = new AddBouquetController();
        controller.nameField = new TextField();
        controller.quantityField = new TextField();
        controller.priceField = new TextField();
        controller.mesaj = new Text();
    }
    @AfterAll
    public static void tearDown() throws Exception{
        BouquetService.closeDatabase();
    }

    @DisplayName("Name Bouquet Field is empty")
    @Test
    public void test_nameField_fail() {
        controller.nameField.setText("");
        controller.quantityField.setText("1");
        controller.priceField.setText("12");
        controller.saveButton();
     //  assertThrows(BouquetNameFieldEmptyException.class, () -> {});
        assertEquals(controller.getMesaj(), "Bouquet already exists!");
    }

    @DisplayName("Buchetul deja exista")
    @Test
    public void test_addAnExistingBouquet() throws IOException {
        controller.nameField.setText("floricele");
        controller.quantityField.setText("1");
        controller.priceField.setText("12");
        controller.saveButton();
        assertEquals(controller.getMesaj(), "Bouquet already exists!");
    }
    @DisplayName("Buchetul deja exista")
    @Test
    public void test_priceOrQuantityAreNotIntegers(){
        controller.nameField.setText("floricele4");
        controller.quantityField.setText("1.1");
        controller.priceField.setText("12");
        controller.saveButton();
        assertEquals(controller.getMesaj(), "Quantity and price must be integers!");
    }

    @DisplayName("Buchet adaugat")
    @Test
    public void test_bouquetAdded(){
        controller.nameField.setText("floricele3");
        controller.quantityField.setText("1");
        controller.priceField.setText("12");
        controller.saveButton();
        assertEquals(controller.getMesaj(), "Bouquet added!");
    }
}
