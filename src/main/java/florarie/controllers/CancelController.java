package florarie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CancelController {
    @FXML
    private static Button cancelButton;

    public static void initialize() {
        cancelButton.setOnAction(e -> {
            // Get the current stage
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            // Close the stage to return to the previous page
            stage.close();
        });
    }
}

