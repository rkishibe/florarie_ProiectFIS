module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;

    requires org.slf4j;
    requires org.testfx.junit5;



    opens com.example.florarie_proiect;
    exports com.example.florarie_proiect;
    opens com.example.florarie_proiect.controllers;
    exports com.example.florarie_proiect.controllers;
    opens com.example.florarie_proiect.exceptions;
    exports com.example.florarie_proiect.exceptions;
    opens com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.model;
    opens com.example.florarie_proiect.services;
    exports com.example.florarie_proiect.services;
}
