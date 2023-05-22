package com.example.florarie_proiect.exceptions;

public class CouldNotWriteBouquetException extends RuntimeException {
    public CouldNotWriteBouquetException() {
        super(String.format("Could not write bouquet."));
    }
}
