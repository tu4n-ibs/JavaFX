module com.example.appguessthenumber {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.appguessthenumber to javafx.fxml;
    exports com.example.appguessthenumber;
}