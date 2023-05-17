module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;
    requires org.apache.commons.io;
    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect.model;
    exports com.example.florarie_proiect.controllers;
    opens com.example.florarie_proiect.controllers to javafx.fxml;
    exports com.example.florarie_proiect;
    opens com.example.florarie_proiect.model to unnamed;
}
