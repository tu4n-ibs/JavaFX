module com.example.thuchanh1 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.thuchanh1 to javafx.fxml;
    exports com.example.thuchanh1;
}