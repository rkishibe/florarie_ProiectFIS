package com.example.florarie_proiect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardController {

    @FXML
    private TextField numarCardField;

    @FXML
    private TextField numeDetinatorField;

    @FXML
    private DatePicker dataExpirareField;
    @FXML
    private TextField codSecuritateField;

    @FXML
    private Button sendButton;



  /*  public void sendButton(ActionEvent e)
    {
        System.out.println("send");
    }*/
    @FXML
    public void sendButton(ActionEvent event) throws IOException {
        String numarCard = numarCardField.getText();
        String numeDetinator = numeDetinatorField.getText();
        String dataExpirare = dataExpirareField.getValue().toString();

        // verificam daca datele sunt valide
        boolean isDataValid = isCardDataValid(numarCard, numeDetinator, dataExpirare, codSecuritateField.getText());

        if (isDataValid) {
            // daca datele sunt valide, ne intoarcem la pagina de home
            // aici puteti inlocui "Home.fxml" cu numele fisierului FXML al paginii home din aplicatia voastra
            // SceneChanger.changeScene(sendButton, "Home.fxml");
            System.out.println("VALID");

            Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/DetaliiComanda.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
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
            System.out.println("nr card");
            return false;
        }

        // verificam daca codul de securitate are 3 cifre
        if (!codSecuritate.matches("\\d{3}")) {
            System.out.println("cod");
            return false;
        }

        // verificam daca data de expirare este valida
      //  try {
            // parsam data in formatul "MM/ZZ/YYYY"
      /*  String month = dataExpirare.substring(0, 2);
        if (month.endsWith("/")) {
            month = month.substring(0, month.length() - 1);
        }
        int expMonth = Integer.parseInt(month);
            int expYear = Integer.parseInt(dataExpirare.substring(8));*/
        LocalDate selectedDate = dataExpirareField.getValue();
        int expYear, expMonth;
        if (selectedDate != null) {
            expMonth = selectedDate.getMonthValue();
            expYear = selectedDate.getYear() % 100; // Extragem ultimele două cifre ale anului

            // obtinem data curenta
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR) % 100; // luam doar ultimele 2 cifre ale anului
            int currentMonth = calendar.get(Calendar.MONTH) + 1; // lunile incep de la 0 in Calendar, asa ca trebuie sa adaugam 1

            // verificam daca data de expirare este in viitor
            if (expYear < currentYear || (expYear == currentYear && expMonth < currentMonth)) {
                System.out.println("data");
                return false;
            }
        }
       // } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            // daca data nu poate fi parsata, inseamna ca nu e valida
         //   return false;
       // }

        // daca toate verificarile au trecut, inseamna ca datele sunt valide
        return true;
    }

    public void switchToSceneFinishOrder(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/cartPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }

}
