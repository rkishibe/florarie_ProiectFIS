package com.example.florarie_proiect.controllers;
import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.time.LocalDate;


    class CardControllerTest extends ApplicationTest {

        @Override
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/finishOrderPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @DisplayName("Am apasat pe butonul de send, iar datele sunt invalide")
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

        }
    }

