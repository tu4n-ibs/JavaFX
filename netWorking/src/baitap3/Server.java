package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("server is running and waiting client accept...");
        Socket socket = serverSocket.accept();
        System.out.println("client connected");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        while (true) {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("receive message form client: " + message);
                System.out.println("enter message: ");

                String messageServer = sc.nextLine();
                outputStream.write(messageServer.getBytes());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
