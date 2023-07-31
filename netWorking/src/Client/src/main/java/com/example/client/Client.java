package com.example.client;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;
    public Client(Socket socket){
        try {
            this.socket = socket;
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
            close(socket,br,bw);
        }
    }
    public void close(Socket socket, BufferedReader br, BufferedWriter bw){
        try {
            if (socket != null){
                socket.close();
            }
            if (br != null){
                br.close();
            }if (bw != null){
                bw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void receiveMessageFromServer(VBox vbox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String message = br.readLine();
                        HelloController helloController = new HelloController();
                        helloController.addLabel(message,vbox);
                    }catch (IOException e){
                        e.printStackTrace();
                        close(socket,br,bw);
                    }
                }
            }
        }).start();
    }

    public void sendMessageToServer(String messageToServer) {
        try {
            bw.write(messageToServer);
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
            close(socket,br,bw);
        }
    }
}
