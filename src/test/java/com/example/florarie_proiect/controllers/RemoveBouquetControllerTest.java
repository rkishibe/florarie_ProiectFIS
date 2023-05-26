package com.example.florarie_proiect.controllers;

import static org.dizitart.no2.Document.createDocument;
import static org.junit.jupiter.api.Assertions.*;


import com.example.florarie_proiect.services.BouquetService;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;

class RemoveBouquetControllerTest extends ApplicationTest {

    private static final String DATABASE_PATH = "./test-db.db";

    private Nitrite testDb;

    @Override
    public void start(Stage stage) throws IOException {
        // Creează un fișier de bază de date de test goală
        testDb = Nitrite.builder()
                .filePath(DATABASE_PATH)
                .openOrCreate();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/florarie_proiect/RemoveBouquet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    void setUp() {
        // Inițializăm baza de date de test cu un buchet
        BouquetService.loadBouquetsFromDatabase();
        Document doc = createDocument("name", "Buchet1" )
                .put("quantity",10 )
                .put("price", 5);
        BouquetService.addBouquet(doc);

    }

    @AfterEach
    void tearDown() {
        // Închidem baza de date de test și ștergem fișierul
        BouquetService.closeDatabase();
        testDb.close();
        Path dbPath = Paths.get(DATABASE_PATH);
        if (Files.exists(dbPath)) {
            try {
                Files.delete(dbPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void initialize(FxRobot robot) {
        // Verificăm că lista de opțiuni ChoiceBox este populată corect
        ChoiceBox<String> choiceBox = robot.lookup("#choice").queryChoiceBox();
        assertNotNull(choiceBox);
        ObservableList<String> actualItems = choiceBox.getItems();
        assertEquals(actualItems.size(), 1);
        assertEquals(actualItems.get(0), "Buchet1");
    }

    @Test
    void okButton(FxRobot robot) {
        robot.clickOn("#okButton");
        assertThat(robot.lookup("#mesaj").queryText()).hasText("Bouquet removed!");
        assertEquals(BouquetService.getFlowerCollection().size(), 0);
    }
}
