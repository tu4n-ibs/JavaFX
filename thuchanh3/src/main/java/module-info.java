module com.example.thuchanh3 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.thuchanh3 to javafx.fxml;
    exports com.example.thuchanh3;
}