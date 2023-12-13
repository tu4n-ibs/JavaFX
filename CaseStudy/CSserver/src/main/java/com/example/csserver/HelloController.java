package com.example.csserver;

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
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private TextField textField;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox;
    private Server server;
    int port = 8888;

    public HelloController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            server = new Server(serverSocket);
        }catch (IOException e){
            e.printStackTrace();
        }
        vbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scrollPane.setVvalue((Double) t1);
            }
        });
        server.receiveMessageFromClient(vbox);
        server.display(vbox);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String message = textField.getText();
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.setPadding(new Insets(5,5,5,10));
                Text text = new Text(message);
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-color:rgb(239,242,255); -fx-background-color: rgb(15,125,242); -fx-background-radius: 20px");
                textFlow.setPadding(new Insets(5,10,5,10));
                text.setFill(Color.color(0.934,0.945,0.996));
                hBox.getChildren().add(textFlow);
                vbox.getChildren().add(hBox);
                server.sendMessageToClient(message);
                textField.clear();
            }
        });
    }
    public void AddLabelForMessageReceive(String message , VBox vbox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));
        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: rgb(233,233,255) ; -fx-background-radius: 20px");
        textFlow.setPadding(new Insets(5,10,5,10));
        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });
    }

}
