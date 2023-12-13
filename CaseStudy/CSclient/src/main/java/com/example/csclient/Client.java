package com.example.csclient;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.io.*;
import java.net.Socket;
import java.sql.*;

public class Client {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private ConnectJDBC connectJDBC = new ConnectJDBC();
    private Connection connection;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.connection = connectJDBC.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageFromServer(VBox vbox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String message = bufferedReader.readLine();
                        HelloController helloController = new HelloController();
                        helloController.addLabel(message, vbox);
                        saveMessageReceive(message);
                        System.out.println("receive from server: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void sendMessageToClient(String messageToServer) {
        try {
            saveMessageSend(messageToServer);
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("send message to client : " + messageToServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveMessageReceive(String message) {
        if (message != null) {
            String query = "insert into client(receive) values(?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveMessageSend(String message) {
        if (message != null) {
            String query = "insert into client(send) values(?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void display(VBox vBox) {
        String query = "select * from client";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String send = resultSet.getString("send");
                String receive = resultSet.getString("receive");
                if (send != null) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_LEFT);
                    hBox.setPadding(new Insets(5, 5, 5, 10));
                    Text text = new Text(send);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-background-color: rgb(233,233,255) ; -fx-background-radius: 20px");
                    textFlow.setPadding(new Insets(5, 10, 5, 10));

                    hBox.getChildren().add(textFlow);
                    vBox.getChildren().add(hBox);
                }
                if (receive != null) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5, 5, 5, 10));

                    Text text = new Text(receive);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color:rgb(239,242,255);-fx-background-color: rgb(15,125,242);-fx-background-radius: 20px");
                    textFlow.setPadding(new Insets(5, 10, 5, 10));
                    text.setFill(Color.color(0.934, 0.945, 0.996));

                    hBox.getChildren().add(textFlow);
                    vBox.getChildren().add(hBox);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
