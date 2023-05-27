package com.example.florarie_proiect.controllers;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.florarie_proiect.model.Bouquet;
import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(ApplicationExtension.class)

    class DetaliiComandaControllerTest {

        private ObservableList<Bouquet> selectedBouquets;


        @Start
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/DetaliiComanda.fxml"));
            stage.setTitle("DETALII COMANDA Example");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }

        @BeforeEach
        public  void setUp() throws Exception {
            FxToolkit.registerPrimaryStage();
            controller = new DetaliiComandaController();

        }

        private DetaliiComandaController controller;
        @Test
        public void test_initialize() {
            // Inițializăm listă de buchete selectate pentru test
            Bouquet bouquet1 = new Bouquet("Buchet 1", 10, 5);
            Bouquet bouquet2 = new Bouquet("Buchet 2", 15, 3);
            selectedBouquets = FXCollections.observableArrayList(bouquet1, bouquet2);
            // Setăm lista de buchete selectate
            BouquetListController.setSelectedBouquets(selectedBouquets);

            // Apelul metodei initialize()
            WaitForAsyncUtils.waitForFxEvents();
            controller.initialize();

            // Verificarea rezultatelor
            ObservableList<Bouquet> data = controller.table.getItems();
            assertEquals(selectedBouquets, data);

            int expectedTotal = calculateTotalPrice(selectedBouquets);
            int actualTotal = Integer.parseInt(controller.total.getText());
            assertEquals(expectedTotal, actualTotal);
        }

        private int calculateTotalPrice(ObservableList<Bouquet> bouquets) {
            int total = 0;
            for (Bouquet bouquet : bouquets) {
                total += bouquet.getPrice() * bouquet.getQuantity();
            }
            return total;
        }


        @Test
        void switchToSceneHome(FxRobot robot) {
            robot.clickOn("#backButton");

            // Verify that the scene is switched to the home page
            Node modifyPage = robot.lookup("#home").query();
            assertNotNull(modifyPage);
            Scene scene =modifyPage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/home.fxml", scene.getRoot().getId());

        }
    }

