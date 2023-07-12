module com.example.javafx2thuchanh2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javafx2thuchanh2 to javafx.fxml;
    exports com.example.javafx2thuchanh2;
}