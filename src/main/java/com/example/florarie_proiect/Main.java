package com.example.florarie_proiect;

import com.example.florarie_proiect.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/login.fxml")));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        UserService.loadUsersFromFile();*/
        System.out.println(Main.class.getResourceAsStream("/resources/com.example.florarie_proiect/login.fxml"));
       /* try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/register.fxml")));
            primaryStage.setTitle("Inregistrare");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        launch();
    }
}