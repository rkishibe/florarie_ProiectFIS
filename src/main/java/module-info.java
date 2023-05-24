module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;
    requires org.apache.commons.io;

    requires org.junit.platform.commons;


    opens com.example.florarie_proiect to javafx.fxml;

    exports com.example.florarie_proiect;
    exports com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.controllers;
    exports com.example.florarie_proiect.services;

    opens com.example.florarie_proiect.controllers to javafx.fxml;

    exports com.example.florarie_proiect.exceptions;

}
