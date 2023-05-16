package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;

public class CardController {

    @FXML
    private TextField numarCardField;

    @FXML
    private TextField numeDetinatorField;

    @FXML
    private TextField dataExpirareField;

    @FXML
    private TextField codSecuritateField;

    @FXML
    private Button sendButton;

    @FXML
    public void sendButton(ActionEvent e)
    {
        System.out.println("send");
    }
    /*
    public void handleSendButton(ActionEvent event) throws IOException {
        String numarCard = numarCardField.getText();
        String numeDetinator = numeDetinatorField.getText();
        String dataExpirare = dataExpirareField.getText();

        // verificam daca datele sunt valide
        boolean isDataValid = isCardDataValid(numarCard, numeDetinator, dataExpirare, codSecuritateField.getText());

        if (isDataValid) {
            // daca datele sunt valide, ne intoarcem la pagina de home
            // aici puteti inlocui "Home.fxml" cu numele fisierului FXML al paginii home din aplicatia voastra
            // SceneChanger.changeScene(sendButton, "Home.fxml");
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("home.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 800, 600);
            Stage stage = (Stage) sendButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        } else {
            // daca datele sunt invalide, afisam un mesaj de eroare
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid card data");
            alert.setHeaderText(null);
            alert.setContentText("Datele cardului sunt invalide!");
            alert.showAndWait();
        }
    }



    private boolean isCardDataValid(String numarCard, String numeDetinator, String dataExpirare, String codSecuritate) {
        // verificam daca toate campurile sunt completate
        if (numarCard.isEmpty() || numeDetinator.isEmpty() || dataExpirare.isEmpty() || codSecuritate.isEmpty()) {
            return false;
        }

        // verificam daca numarul de card are 16 cifre
        if (!numarCard.matches("\\d{16}")) {
            return false;
        }

        // verificam daca codul de securitate are 3 cifre
        if (!codSecuritate.matches("\\d{3}")) {
            return false;
        }

        // verificam daca data de expirare este valida
        try {
            // parsam data in formatul "MM/YY"
            int expMonth = Integer.parseInt(dataExpirare.substring(0, 2));
            int expYear = Integer.parseInt(dataExpirare.substring(3));

            // obtinem data curenta
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR) % 100; // luam doar ultimele 2 cifre ale anului
            int currentMonth = calendar.get(Calendar.MONTH) + 1; // lunile incep de la 0 in Calendar, asa ca trebuie sa adaugam 1

            // verificam daca data de expirare este in viitor
            if (expYear < currentYear || (expYear == currentYear && expMonth < currentMonth)) {
                return false;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            // daca data nu poate fi parsata, inseamna ca nu e valida
            return false;
        }

        // daca toate verificarile au trecut, inseamna ca datele sunt valide
        return true;
    }*/

}
