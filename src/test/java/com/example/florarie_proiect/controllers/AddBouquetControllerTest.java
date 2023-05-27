package com.example.florarie_proiect.controllers;


import com.example.florarie_proiect.exceptions.BouquetNameFieldEmptyException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddBouquetControllerTest {
    @FXML
    public Button saveButton;
    private AddBouquetController controller;

    @BeforeEach
    public void setUp() throws Exception {
        //BouquetService.loadBouquetsFromDatabase();
        controller = new AddBouquetController();
        FxToolkit.registerPrimaryStage();
        controller.nameField = new TextField();
        controller.quantityField = new TextField();
        controller.priceField = new TextField();
        controller.mesaj = new Text();
    }

    @Test
    public void test_nameField_fail() throws IOException {
        controller.nameField.setText(null);
        controller.quantityField.setText("1");
        controller.priceField.setText("12");
        controller.saveButton();
        assertThrows(BouquetNameFieldEmptyException.class, () -> {
        });
    }

    @Test
    public void test_addCorrect() {
        controller.nameField.setText("floricele");
        controller.quantityField.setText("1");
        controller.priceField.setText("12");
        assertEquals(controller.getMesaj(), "Bouquet added!");
    }
}
