package thuchanh4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class server {
    public static void main(String[] args){
        int serverPort = 8080;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("server is running and waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("client connected.");

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0,bytesRead);
            System.out.println("receive message form client: " + message);

            socket.close();
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
