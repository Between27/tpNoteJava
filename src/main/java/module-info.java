module com.example.tpnotejava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tpnotejava to javafx.fxml;
    exports com.example.tpnotejava;
    exports modele;
    opens modele to javafx.fxml;
}