package com.example.quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class quizApplocation extends Application {
    private int score = 0;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exercise App");
        HBox hBox1 = new HBox();
        Label questionLabel = new Label("1+1=?");
        RadioButton button1 = new RadioButton("1");
        RadioButton button2 = new RadioButton("2");
        RadioButton button3 = new RadioButton("3");

        ToggleGroup toggleGroup = new ToggleGroup();
        button1.setToggleGroup(toggleGroup);
        button2.setToggleGroup(toggleGroup);
        button3.setToggleGroup(toggleGroup);

        HBox hBox2 = new HBox();
        Label questionLabel2 = new Label("2+2=?");
        RadioButton button5 = new RadioButton("1");
        RadioButton button6 = new RadioButton("2");
        RadioButton button8 = new RadioButton("4");

        ToggleGroup toggleGroup1 = new ToggleGroup();
        button5.setToggleGroup(toggleGroup1);
        button6.setToggleGroup(toggleGroup1);
        button8.setToggleGroup(toggleGroup1);


        Label label = new Label("Score: ");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        Button submit = new Button("Submit");
        submit.setOnAction(actionEvent -> {
            if (button2.isSelected()) {
                score = score +1;
                alert.setContentText("diem cua ban: " + score);
                alert.show();
            } else{
                score = 0;
                alert.setContentText("diem cua ban: " + score);
                alert.show();
            }
            if (button8.isSelected()) {
                score = score + 1;
                alert.setContentText("diem cua ban: " + score);
                alert.show();
            } else {
                score = 0;
                alert.setContentText("diem cua ban: " + score);
                alert.show();
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(questionLabel, button1, button2, button3, questionLabel2, button5,
                button6, button8,
                submit, label);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
