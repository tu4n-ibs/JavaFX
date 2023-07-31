package baitap1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
//        serverPort
        int serverPort = 8080;

        try {
//            kết nối ServerSocket qua serverPort
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("server is running and waiting client accept");
//            chờ đợi Client chấp nhận kết nối
            Socket socket = serverSocket.accept();
            System.out.println("client connected");
//            đọc dữ liệu
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int number1 = dataInputStream.readInt();
            int number2 = dataInputStream.readInt();
//           cộng hai số và ghi dữ liệu
            int sum = number1 + number2;
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeInt(sum);
//            đóng
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
