module com.example.thuchanh2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.thuchanh2 to javafx.fxml;
    exports com.example.thuchanh2;
}