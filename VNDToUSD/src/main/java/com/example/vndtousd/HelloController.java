package com.example.vndtousd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField usdTextField;
    @FXML
    private double Rate = 23000;
    @FXML
    private Label vndValueLabel;

    @FXML
    private void convertCurrency() {
            double usdValue = Double.parseDouble(usdTextField.getText());
            double vndValue = usdValue * Rate;
//            vndValueLabel.setText(String.valueOf(vndValue));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText( usdValue + " = "+vndValue + "vnd");
            alert.show();
    }
}