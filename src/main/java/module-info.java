module com.example.florarie_proiect {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires nitrite;
    requires org.apache.commons.io;
    requires org.junit.platform.commons;
    requires org.testfx;
    requires org.testfx.junit5;
    requires hamcrest.core;

    opens com.example.florarie_proiect to org.junit.platform.commons, javafx.fxml;

    exports com.example.florarie_proiect to javafx.fxml, javafx.graphics;
    opens com.example.florarie_proiect.controllers to org.junit.platform.commons, org.testfx.junit5,javafx.fxml;
    opens com.example.florarie_proiect.services to org.junit.platform.commons, org.testfx.junit5;

    opens com.example.florarie_proiect.model;
    opens com.example.florarie_proiect.exceptions;
}
