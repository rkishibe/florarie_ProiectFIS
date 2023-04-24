module com.example.florarie_proiect {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.florarie_proiect to javafx.fxml;
    exports com.example.florarie_proiect;
}