package com.example.florarie_proiect.exceptions;

public class BouquetDoesntExistException extends  RuntimeException{
    public BouquetDoesntExistException() {
        super(String.format("Bouquet doesn't exist!"));
    }
}
