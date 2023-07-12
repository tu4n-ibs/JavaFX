package com.example.quiz;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class quizController extends Application {
    public VBox vBox;
    @Override
    public void start(Stage stage) throws Exception {
        this.vBox = new VBox();
        HBox hBox1 = new HBox();
        Label question = new Label();
        question.setText("1 + 1 = ?");
        System.out.println(question.getText());

        HBox hBox2 = new HBox();
        VBox vBox2 = new VBox();
        RadioButton button1 = new RadioButton("1");
        RadioButton button2 = new RadioButton("2");
        RadioButton button3 = new RadioButton("3");
        vBox2.getChildren().addAll(button1, button2, button3);
        hBox2.getChildren().addAll(vBox2);
        hBox1.getChildren().addAll(hBox2);
        this.vBox.getChildren().addAll(hBox1);
    }

    public static void main(String[] args) {
        launch();
    }
}