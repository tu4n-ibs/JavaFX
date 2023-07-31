module com.example.baitap4 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.baitap4 to javafx.fxml;
    exports com.example.baitap4;
}