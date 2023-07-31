package com.example.client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {
    @FXML
    private Button button;
    @FXML
    private TextField textField;
    @FXML
    private ScrollPane sp_main;
    @FXML
    private VBox vbox;

    private Client client;
    private int serverPort = 8080;
    private String serverIP = "127.0.0.1";

    public HelloController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            client = new Client(new Socket(serverIP,serverPort));
        }catch (IOException e){
            e.printStackTrace();
        }

        vbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((Double) t1);
            }
        });

        client.receiveMessageFromServer(vbox);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String messageToServer = textField.getText();
                if (!messageToServer.isEmpty()){
                    HBox hBox = new HBox();

                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5,5,5,10));

                    Text text = new Text(messageToServer);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(243,252,276) ; -fx-background-color: rgb(41,108,205) ; -fx-background-radius: 20px");
                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(0.934,0.936,0.996));

                    hBox.getChildren().add(textFlow);
                    vbox.getChildren().add(hBox);

                    client.sendMessageToServer(messageToServer);
                    textField.clear();
                }
            }
        });
    }
    public void addLabel(String messageToServer, VBox vbox){
        HBox hBox = new HBox();

        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(2,2,2,5));

        Text text = new Text(messageToServer);
        TextFlow textFlow = new TextFlow(text);

        textFlow.setStyle("-fx-background-color: rgb(9,1,1) ; -fx-background-radius: 20px");
        textFlow.setPadding(new Insets(2,5,2,5));
        text.setFill(Color.color(0.934,0.936,0.996));

        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });
    }
}