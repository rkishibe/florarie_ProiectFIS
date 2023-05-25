package com.example.florarie_proiect.controllers;
import javafx.collections.FXCollections;
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
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    class DetaliiComandaControllerTest extends ApplicationTest {

        private ObservableList<Bouquet> selectedBouquets;

        @BeforeEach
        void setUp() {
            BouquetService.loadBouquetsFromDatabase();
        }
        @AfterEach
        void tearDown(){
            BouquetService.closeDatabase();
        }
        @Override
        public void start(Stage stage) throws IOException {
            // Inițializăm listă de buchete selectate pentru test
            Bouquet bouquet1 = new Bouquet("Buchet 1", 10, 5);
            Bouquet bouquet2 = new Bouquet("Buchet 2", 15, 3);
            selectedBouquets = FXCollections.observableArrayList(bouquet1, bouquet2);

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/DetaliiComanda.fxml"));
            stage.setTitle("DETALII COMANDA Example");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }

        @Test
        void initialize(FxRobot robot) {
            // Verificăm că tabelul este populat cu buchetele selectate
            TableView<Bouquet> table = robot.lookup("#table").queryTableView();
            assertNotNull(table);
            List<TableColumn<Bouquet, ?>> columns = table.getColumns();
            assertEquals(3, columns.size()); // Verificăm că există 3 coloane

            TableColumn<Bouquet, String> nameColumn = (TableColumn<Bouquet, String>) columns.get(0);
            assertEquals("name", nameColumn.getText());

            TableColumn<Bouquet, Integer> priceColumn = (TableColumn<Bouquet, Integer>) columns.get(1);
            assertEquals("price", priceColumn.getText());

            TableColumn<Bouquet, Integer> quantityColumn = (TableColumn<Bouquet, Integer>) columns.get(2);
            assertEquals("quantity", quantityColumn.getText());

            ObservableList<Bouquet> actualData = table.getItems();
            assertEquals(selectedBouquets, actualData);

            // Verificăm că suma totală este calculată corect
            TextField totalField = robot.lookup("#total").queryAs(TextField.class);
            assertNotNull(totalField);
            int expectedTotal = selectedBouquets.stream().mapToInt(bouquet -> bouquet.getPrice() * bouquet.getQuantity()).sum();
            assertEquals(String.valueOf(expectedTotal), totalField.getText());
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

