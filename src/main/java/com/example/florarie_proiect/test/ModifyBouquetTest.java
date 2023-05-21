package com.example.florarie_proiect.test;

import com.example.florarie_proiect.exceptions.CouldNotWriteBouquetException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModifyBouquetTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Testing the format for modifying a bouquet is correct.")
    void modifyBouquet(FxRobot robot) {
        robot.clickOn("#name");

    }

    @Test
    @DisplayName("Testing if the bouquet is persisted to the database.")
    void saveBouquetToDatabase() {

    }

    @Test
    void couldNotWriteBouquetException() {
        assertThrows(CouldNotWriteBouquetException.class, () -> {});
    }

    @AfterEach
    void tearDown() {

    }
}
