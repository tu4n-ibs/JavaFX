package com.example.javafx2thuchanh2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileChooserController {
    @FXML
    protected ImageView imageview;
    @FXML
    private AnchorPane ap;

    @FXML
    public void chooseImage(ActionEvent event) {
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new
                FileChooser.ExtensionFilter("Image file", "*jpeg", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageview.setImage(image);
        }

    }
}