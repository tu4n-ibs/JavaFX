package com.example.informationsurvey;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class InformationController {
    @FXML
    private TextField name;
    @FXML
    private TextField date;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private CheckBox check6;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;

    String fileName = "Data.txt";

    @FXML
    protected void onHelloButtonClick() {
        String name1 = name.getText();
        String date1 = date.getText();
        String checkName = check1.getText();
        String checkName1 = check2.getText();
        String checkName2 = check3.getText();
        String checkName3 = check4.getText();
        String checkName4 = check5.getText();
        String checkName5 = check6.getText();
        String test = "";
        if (male.isSelected()) {
            test = male.getText();
        } else if (female.isSelected()) {
            test = female.getText();
        }
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(fileName);
            fileWriter.write("name: " + name1 + "\n");
            fileWriter.write("date: " + date1 + "\n");
            fileWriter.write("hobby: " + "\n" + checkName + "\n" + checkName1 + "\n" + checkName2 + "\n" + checkName3 + "\n" + checkName4 + "\n" + checkName5 + "\n");
            fileWriter.write("sex: " + test+ "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thanh cong !!!");
    }
}