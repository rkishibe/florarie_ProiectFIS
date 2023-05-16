module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires nitrite;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;
    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.controllers;
    opens com.example.florarie_proiect.controllers to javafx.fxml;
    exports com.example.florarie_proiect;
}
