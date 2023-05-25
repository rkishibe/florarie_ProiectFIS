package com.example.florarie_proiect.controllers;
import com.example.florarie_proiect.controllers.AddBouquetController;
import com.example.florarie_proiect.services.BouquetService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBouquetControllerTest  {
    public static final String NAME = "numeBuchet";
    public static final String PRET = "100";
    public static final String CANTITATE = "23";


    private AddBouquetController controller;

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/addBouquet.fxml"));
        primaryStage.setTitle("ADD BOUQUET Example");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    @BeforeEach
    public void setUp() throws Exception {
        BouquetService.loadBouquetsFromDatabase();
    }
    @AfterEach
    public void setDown() throws Exception{
        BouquetService.closeDatabase();
    }

    @Test
    public void testSaveButton(FxRobot robot) throws IOException {
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

       // robot.clickOn("#saveButton");
        //assertEquals(robot.lookup("#mesaj").queryText(), "Bouquet already exists!");


        //robot.clickOn("#nameField");
       // robot.write("1");
       // robot.clickOn("#saveButton");

    }
}
