package com.example.florarie_proiect.exceptions;

public class BouquetNameFieldEmptyException
        extends  RuntimeException{
    public BouquetNameFieldEmptyException() {
        super(String.format("Bouquet name field empty!"));
    }
}