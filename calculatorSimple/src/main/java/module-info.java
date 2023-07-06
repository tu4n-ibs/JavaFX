module com.example.calculatorsimple {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.calculatorsimple to javafx.fxml;
    exports com.example.calculatorsimple;
}