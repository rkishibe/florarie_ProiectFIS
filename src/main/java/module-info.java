module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;


    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect.model to com.fasterxml.jackson.databind;
    exports com.example.florarie_proiect;

}