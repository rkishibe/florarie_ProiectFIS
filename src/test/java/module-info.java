open module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;
    requires org.apache.commons.io;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires org.testfx;
    requires org.testfx.junit5;
    requires org.assertj.core;
    requires hamcrest.core;
    requires com.example.florarie_proiect;

    exports com.example.florarie_proiect;
}