module com.example.quanlythongtin {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.quanlythongtin to javafx.fxml;
    exports com.example.quanlythongtin;
}