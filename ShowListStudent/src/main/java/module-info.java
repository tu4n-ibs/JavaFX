module com.example.showliststudent {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.showliststudent to javafx.fxml;
    exports com.example.showliststudent;
}