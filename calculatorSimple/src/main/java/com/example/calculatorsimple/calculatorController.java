package com.example.calculatorsimple;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class calculatorController {
    @FXML
    private TextField number1;
    @FXML
    private TextField number2;
    @FXML
    protected void onCongButtonClick() {
        int num1 = Integer.parseInt(number1.getText());
        int num2 = Integer.parseInt(number2.getText());
        int resul = num1 + num2;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("ket qua " + resul);
        alert.show();
    }
    @FXML
    protected void onTruButtonClick() {
        int num1 = Integer.parseInt(number1.getText());
        int num2 = Integer.parseInt(number2.getText());
        int resul = num1 - num2;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("ket qua " + resul);
        alert.show();
    }@FXML
    protected void onNhanButtonClick() {
        int num1 = Integer.parseInt(number1.getText());
        int num2 = Integer.parseInt(number2.getText());
        int resul = num1 * num2;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("ket qua " + resul);
        alert.show();
    }@FXML
    protected void onChiaButtonClick() {
        int num1 = Integer.parseInt(number1.getText());
        int num2 = Integer.parseInt(number2.getText());
        int resul = num1 / num2;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("ket qua " + resul);
        alert.show();
    }
}