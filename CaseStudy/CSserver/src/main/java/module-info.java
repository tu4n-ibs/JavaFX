module com.example.csserver {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csserver to javafx.fxml;
    exports com.example.csserver;
}