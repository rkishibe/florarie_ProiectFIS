package com.example.florarie_proiect.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

class ClientHomeTest {
    @ExtendWith(ApplicationExtension.class)
    public class AdminHomeControllerTest {
        @Start
        void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/com/example/florarie_proiect/ClientHome.fxml"));
            primaryStage.setTitle("CLIENT HOME Example");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }
        @Test
        public void testSwitchToSceneHome(FxRobot robot) {
            robot.clickOn("#homeButton");

            Node homePage = robot.lookup("#adminHome").query();
            assertNotNull(homePage);
            Scene scene = homePage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/AdminHome.fxml", scene.getRoot().getId());
        }

        @Test
        public void testSwitchToSceneBouquetList(FxRobot robot) {
            robot.clickOn("#bouquetButton");

            Node modifyPage = robot.lookup("#chooseBouquetPage").query();
            assertNotNull(modifyPage);
            Scene scene = modifyPage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/BouquetList.fxml", scene.getRoot().getId());
        }

        @Test
        public void testSwitchToSceneCartPage(FxRobot robot) {
            robot.clickOn("#cartButton");

            Node removePage = robot.lookup("#cartPage").query();
            assertNotNull(removePage);
            Scene scene = removePage.getScene();
            assertNotNull(scene);
            assertEquals("/com/example/florarie_proiect/cartPage.fxml", scene.getRoot().getId());
        }


    }


}