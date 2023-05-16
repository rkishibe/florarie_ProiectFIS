package com.example.florarie_proiect.model;

public class CardCredit {
    private String numarCard;
    private String numeDetinator;
    private String dataExpirare;
    private int codSecuritate;

    public CardCredit(String numarCard, String numeDetinator, String dataExpirare, int codSecuritate) {
        this.numarCard = numarCard;
        this.numeDetinator = numeDetinator;
        this.dataExpirare = dataExpirare;
        this.codSecuritate = codSecuritate;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public void setNumarCard(String numarCard) {
        this.numarCard = numarCard;
    }

    public String getNumeDetinator() {
        return numeDetinator;
    }

    public void setNumeDetinator(String numeDetinator) {
        this.numeDetinator = numeDetinator;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public int getCodSecuritate() {
        return codSecuritate;
    }

    public void setCodSecuritate(int codSecuritate) {
        this.codSecuritate = codSecuritate;
    }
}

