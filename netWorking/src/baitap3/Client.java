package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        while (true) {
            System.out.println("enter message: ");
            String message = sc.nextLine();
            outputStream.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String messageClient = new String(buffer, 0, bytesRead);
            System.out.println("receive message form server: " + messageClient);
        }
    }
}
