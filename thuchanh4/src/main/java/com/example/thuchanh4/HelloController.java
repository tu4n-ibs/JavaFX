package com.example.thuchanh4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    @FXML
    protected void login() {
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.equals("admin") && password.equals("password")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("dang nhap thanh cong");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("dang nhap that bai");
            alert.show();
        }
    }
}