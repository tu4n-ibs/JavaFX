module com.example.informationsurvey {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.informationsurvey to javafx.fxml;
    exports com.example.informationsurvey;
}