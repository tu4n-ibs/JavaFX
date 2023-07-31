package com.example.baitap4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloController {
    @FXML
    TextField textServer;
    @FXML
    Label enterServer;
    ServerSocket serverSocket;
    Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    int serverPort = 8080;

    public HelloController() throws IOException {
        this.serverSocket = new ServerSocket(serverPort);
        System.out.println("server is running and waiting client accept...");
        this.socket = serverSocket.accept();
        System.out.println("client connected");
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }

    @FXML
    public void buttonServer() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("receive message form client: " + message);
            enterServer.setText("receive from Client: " + message);

            String textServer1 = textServer.getText();
            outputStream.write(textServer1.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}