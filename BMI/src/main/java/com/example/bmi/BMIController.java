package com.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class BMIController {
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    protected void onBMIButtonClick() {
        double weight = Double.parseDouble(weightTextField.getText());
        double height = Double.parseDouble(heightTextField.getText());

        double bmi = weight / (height * height);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BMI Calculator");
        alert.setContentText("chi so BMI: " + bmi);
        alert.show();
    }

}