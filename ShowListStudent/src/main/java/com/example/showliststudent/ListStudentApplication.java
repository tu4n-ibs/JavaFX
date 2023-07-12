package com.example.showliststudent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ListStudentApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
        VBox root = loader.load();
        ListStudentController controller = loader.getController();

        // Add sample data
        controller.getListView().getItems().addAll(
                new Student(1, "John Doe", 20),
                new Student(2, "Jane Smith", 22),
                new Student(3, "David Johnson", 19)
        );

        stage.setTitle("Student List");
        stage.setScene(new Scene(root, 200, 300));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}