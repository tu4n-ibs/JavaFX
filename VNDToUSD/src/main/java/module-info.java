module com.example.vndtousd {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.vndtousd to javafx.fxml;
    exports com.example.vndtousd;
}