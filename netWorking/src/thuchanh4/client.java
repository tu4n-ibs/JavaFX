package thuchanh4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int serverPort = 8080;

        try {
            Socket socket = new Socket(serverIP,serverPort);
            OutputStream outputStream = socket.getOutputStream();
            String message = "hello. i'm tuasn";
            outputStream.write(message.getBytes());
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
