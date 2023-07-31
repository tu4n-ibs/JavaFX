package com.example.server;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    public Server(ServerSocket serverSocket){
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){
            e.printStackTrace();
            close(serverSocket,socket,br,bw);
        }
    }
    public void close(ServerSocket serverSocket,Socket socket,BufferedReader br,BufferedWriter bw){
        try {
            if (serverSocket != null){
                serverSocket.close();
            }
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

    public void receiveMessageFromClient(VBox vbox) {
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
                        close(serverSocket,socket,br,bw);
                    }
                }
            }
        }).start();
    }

    public void sendMessageToClient(String messageToClient) {
        try {
            bw.write(messageToClient);
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
            close(serverSocket,socket,br,bw);
        }
    }
}
