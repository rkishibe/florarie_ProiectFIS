module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;
    requires com.google.gson;


    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect;
    exports com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.controllers;
    opens com.example.florarie_proiect.controllers to javafx.fxml;
}
