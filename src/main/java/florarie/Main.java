package florarie;

import florarie.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    Button login, register;
    Scene loginScene, registerScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*login=new Button();
        register=new Button();

        primaryStage.setTitle("Home Page");
        login.setText("Login");
        register.setText("Inregistrare");

        login.setOnAction(e -> primaryStage.setScene(loginScene));
        register.setOnAction(e -> primaryStage.setScene(registerScene));


        StackPane layout=new StackPane();
        layout.getChildren().add(register);
        layout.getChildren().add(login);

        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();*/
        try {
            UserService.loadUsersFromFile();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            primaryStage.setTitle("Inregistrare");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/


    }

    public static void main(String[] args) {
        launch(args);
    }

}