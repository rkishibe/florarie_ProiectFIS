package com.example.florarie_proiect.controllers;
import static org.junit.jupiter.api.Assertions.*;

import com.example.florarie_proiect.services.BouquetService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.time.LocalDate;


    class CardControllerTest extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/finishOrderPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

      /*  @DisplayName("Am apasat pe butonul de send, iar datele sunt invalide")
        @Test
        void sendButtonValidData(FxRobot robot) {
            // Simulăm completarea câmpurilor cu date valide
            robot.clickOn("#numarCardField").write("1234567890123456");
            robot.clickOn("#numeDetinatorField").write("Maria");
            robot.clickOn("#dataExpirareField").write(LocalDate.now().plusMonths(1).toString());
            robot.clickOn("#codSecuritateField").write("123");

            robot.clickOn("#sendButton");
            // Verificăm că scena s-a schimbat la "DetaliiComanda.fxml"
            Node modifyPage = robot.lookup("#DetaliiComanda").query();
            assertNotNull(modifyPage);
            Scene scene =modifyPage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/DetaliiComanda.fxml", scene.getRoot().getId());

        }

        @DisplayName("Am apasat pe butonul de send, dar datele NU sunt invalide")
        @Test
        void sendButtonInvalidData(FxRobot robot) {
            // Simulăm completarea câmpurilor cu date invalide
            robot.clickOn("#numarCardField").write("1234"); // Număr de card prea scurt
            robot.clickOn("#numeDetinatorField").write(""); // Numele detinatorului lipseste
            robot.clickOn("#dataExpirareField").write(LocalDate.now().minusMonths(1).toString()); // Data expirarii in trecut
            robot.clickOn("#codSecuritateField").write("12"); // Codul de securitate prea scurt
            robot.clickOn("#sendButton");

            // Verificăm că s-a afișat un mesaj de eroare
            assertTrue(robot.lookup(".alert").queryAll().size() > 0);
        }

        @DisplayName("Am apasat pe butonul back")
        @Test
        void switchToSceneFinishOrder(FxRobot robot) {
            // Simulăm un eveniment de acțiune pe un buton sau pe un alt element care apelează metoda switchToSceneFinishOrder()
            robot.clickOn("#backButton");

            // Verificăm că scena s-a schimbat la "cartPage.fxml"
            Node modifyPage = robot.lookup("#cartPage").query();
            assertNotNull(modifyPage);
            Scene scene =modifyPage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/cartPage.fxml", scene.getRoot().getId());

        }*/

        private CardController controller;

        @BeforeEach
        public  void setUp() throws Exception {

            FxToolkit.registerPrimaryStage();
            controller = new CardController();
            controller.numarCardField = new TextField();
            controller.numeDetinatorField = new TextField();
            controller.codSecuritateField = new TextField();
            controller.dataExpirareField= new DatePicker();
            controller.mesaj=new Text();
        }

        @Test
        public void test_sendButton_withInvalidCardNumber() {
            controller.numarCardField.setText("123");
            controller.numeDetinatorField.setText("ana");
            controller.dataExpirareField.setValue(LocalDate.of(2025, 12, 31));
            assertDoesNotThrow(() -> controller.sendButton(null));
            assertEquals( controller.getMesaj(), "Date card invalide");
        }
        @Test
        public void test_sendButton_withInvalidCardHolderName() {
            controller.numarCardField.setText("1234567890123456");
            controller.numeDetinatorField.setText("");
            controller.dataExpirareField.setValue(LocalDate.of(2025, 12, 31));
            assertDoesNotThrow(() -> controller.sendButton(null));
            assertEquals( controller.getMesaj(), "Date card invalide");
        }
        @Test
        public void test_sendButton_withInvalidDataExpiration() {
            controller.numarCardField.setText("1234567890123456");
            controller.numeDetinatorField.setText("ana");
            controller.dataExpirareField.setValue(LocalDate.of(2022, 12, 31));
            assertDoesNotThrow(() -> controller.sendButton(null));
            assertEquals( controller.getMesaj(), "Date card invalide");
        }

        @Test
        public void test_sendButton_withValidData() throws IOException {
            controller.numarCardField.setText("1234567890123456");
            controller.numeDetinatorField.setText("Maria");
            controller.dataExpirareField.setValue(LocalDate.of(2023, 5, 27));
            assertDoesNotThrow(() -> controller.sendButton(null));
            assertEquals(controller.getMesaj(), "VALID");
            }
    }

