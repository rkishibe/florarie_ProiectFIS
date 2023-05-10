module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.controller;
    opens com.example.florarie_proiect.controller to javafx.fxml;
}
