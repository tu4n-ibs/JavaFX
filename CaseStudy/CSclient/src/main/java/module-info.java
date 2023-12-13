module com.example.csclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csclient to javafx.fxml;
    exports com.example.csclient;
}