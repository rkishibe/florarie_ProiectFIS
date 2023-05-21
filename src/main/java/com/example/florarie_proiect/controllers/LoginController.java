package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.exceptions.UserDoesNotExistException;
import com.example.florarie_proiect.services.UserService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    private ChoiceBox<String> role;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }
    @FXML
    public void handleLoginButtonAction(ActionEvent event){
        String username = usernameField.getText();
        String password = passwordField.getText();

        try{
           UserService.loadUsersFromDatabase();
            if(UserService.checkPassword(username, password, username) && UserService.checkUserDoesNotExist(username)){
                if(role.getValue().equals("Client")){
                   // loginMessage.setText("Logat ca si client.");
                    Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(homeRoot);
                    stage.setScene(scene);
                    stage.show();
                } else if(role.getValue().equals("Admin")){
                    //loginMessage.setText("Logat ca si admin.");
                    Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/AdminHome.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(homeRoot);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            else {
                loginMessage.setText("Parola sau username gresite!");
            }
        }catch (Exception e){
            e.printStackTrace();
        } catch (UserDoesNotExistException e) {
            throw new RuntimeException(e);

        }
        finally{
            UserService.closeDatabase();
        }


        if (username == null || username.isEmpty()) {
            loginMessage.setText("Tastati un username!");
            return;
        }
        if (password == null || password.isEmpty()) {
            loginMessage.setText("Tastati o parola!");
            return;
        }
    }
    public void switchToSceneHome(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/com/example/florarie_proiect/home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
}