
package com.example.florarie_proiect.controllers;


import com.example.florarie_proiect.Main;
import com.example.florarie_proiect.exceptions.BouquetNameFieldEmptyException;
import com.example.florarie_proiect.services.BouquetService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.dizitart.no2.Document;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class AddBouquetControllerTest {

    public static final String NAME = "numeBuchet";
    public static final String PRET = "100";
    public static final String CANTITATE = "23";



        @Start
        void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/addBouquet.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }


    @BeforeEach
    public  void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();

    }
     FxRobot robot;
          @DisplayName("Test pentru schimbarea scenei de la cea de addBouquet la cea de adminHome")
          @Test
          void switchToSceneHome() {
          robot.clickOn("#cancelButton");
             // verifyThat("page", LabeledMatchers.hasText("Hello Admin"));
          }


          @DisplayName("Test pt adaugarea unui buchet")

          @Test
          public void testAddOK() throws IOException {
          // Setarea imputurilor
          robot.clickOn("#name");
          robot.write(NAME);
          robot.clickOn("#price");
          robot.write(PRET);
          robot.clickOn("#quantity");
          robot.write(CANTITATE);

          robot.clickOn("#save");
          // Verificam message text-ul
          assertEquals(robot.lookup("#mesaj1").queryText(), "Bouquet added!");

          }

          @DisplayName("Test pt adaugarea unui buchet deja existent")

          @Test
          public void testAddExist() throws IOException {
          // Setarea imputurilor
          robot.clickOn("#name");
          robot.write(NAME);
          robot.clickOn("#price");
          robot.write(PRET);
          robot.clickOn("#quantity");
          robot.write(CANTITATE);

          robot.clickOn("#save");
          assertEquals(robot.lookup("#mesaj1").queryText(), "Bouquet already exists!");


          }

         /*
    private AddBouquetController controller;

    @BeforeEach
    public  void setUp() throws Exception {

        FxToolkit.registerPrimaryStage();

        controller = new AddBouquetController();
        FxToolkit.registerPrimaryStage();
        controller.nameField = new TextField();
        controller.quantityField = new TextField();
        controller.priceField = new TextField();
        controller.mesaj = new Text();
    }

    @AfterAll
    public static void tearDown() throws Exception{
        BouquetService.closeDatabase();


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
    }*/
}