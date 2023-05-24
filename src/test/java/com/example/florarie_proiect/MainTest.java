package com.example.florarie_proiect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    @DisplayName("primnul test")
    void firstTest() {
        assertTrue(10 > 1);
    }
}
