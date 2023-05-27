package com.example.florarie_proiect.controllers;

import com.example.florarie_proiect.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class ClientHomeTest {
        @Start
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(Main.class.getResource("/com/example/florarie_proiect/ClientHome.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }

        FxRobot robot;
    @BeforeEach
    public  void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();

    }
        @Test
        public void testSwitchToSceneHome() {
            robot.clickOn("#homeButton");
            verifyThat("#PageTitle", LabeledMatchers.hasText("Welcome to our flower shop!"));
        }

        @Test
        public void testSwitchToSceneBouquetList() {
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


