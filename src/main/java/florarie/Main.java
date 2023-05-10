package florarie;

import florarie.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Button login, register;
    Scene loginScene, registerScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        login=new Button();
        register=new Button();

        Parent loginRoot = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        loginScene=new Scene(loginRoot, 600, 400);

        Parent registerRoot = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        registerScene=new Scene(registerRoot,600,400);

        primaryStage.setTitle("Home Page");
        login.setText("Login");
        register.setText("Inregistrare");

        login.setOnAction(e -> primaryStage.setScene(loginScene));
        register.setOnAction(e -> primaryStage.setScene(registerScene));


        GridPane layout=new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        GridPane.setConstraints(login, 0, 0);
        GridPane.setHalignment(login, HPos.CENTER);


        GridPane.setConstraints(register, 0, 1);
        GridPane.setHalignment(register, HPos.CENTER);

        layout.getChildren().addAll(login, register);

        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
//        try {
//            UserService.loadUsersFromFile();
//
//            primaryStage.setTitle("Inregistrare");
//            primaryStage.setScene(new Scene(root, 300, 275));
//            primaryStage.show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       /* try {

            primaryStage.setTitle("Login");
            primaryStage.setScene();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public static void main(String[] args) {
        launch(args);
    }

}