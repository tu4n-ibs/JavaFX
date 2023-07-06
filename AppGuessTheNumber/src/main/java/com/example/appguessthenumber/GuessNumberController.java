package com.example.appguessthenumber;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class GuessNumberController {
    @FXML
    private TextField numberGuess;
    @FXML
    private int number = (int)(Math.random() *100) +1;
    @FXML
    protected void onGuessNumberButtonClick() {
        int number1 = Integer.parseInt(numberGuess.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (number == number1){
            alert.setContentText("you winner " + number);
            alert.show();
        }else {
            alert.setContentText("you lose " + number);
            alert.show();
        }
    }
}