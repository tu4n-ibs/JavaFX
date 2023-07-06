module com.example.thuchanh4 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.thuchanh4 to javafx.fxml;
    exports com.example.thuchanh4;
}