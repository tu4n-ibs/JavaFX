package com.example.baitap4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientController {
    @FXML
    TextField textClient;
    @FXML
    Label enterClient;
    String serverIP = "127.0.0.1";
    int serverPort = 8080;
    OutputStream outputStream;
    InputStream inputStream;

    public ClientController() throws IOException {
        Socket socket = new Socket(serverIP, serverPort);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
    }

    @FXML
    protected void buttonClient() throws IOException {
        String textClient1 = textClient.getText();
        this.outputStream.write(textClient1.getBytes());

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String messageClient = new String(buffer, 0, bytesRead);
        System.out.println("receive message form server: " + messageClient);
        enterClient.setText("receive from Server: " + messageClient);
    }
}
