package baitap1;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String serverIP = "127.0.0.1";
        int serverPort = 8080;

        try {
//            kết nối IP và Port
            Socket socket = new Socket(serverIP, serverPort);
//            Dataoutput để ghi dữ liệu
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//            nhập dữ liệu
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("enter number one");
            int number1 = Integer.parseInt(bufferedReader.readLine());
            System.out.println("enter number two");
            int number2 = Integer.parseInt(bufferedReader.readLine());
//            ghi dữ liệu
            dataOutputStream.writeInt(number1);
            dataOutputStream.writeInt(number2);
//            đọc dữ liệu Server gửi qua
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int sum = dataInputStream.readInt();
            System.out.println("sum: " + sum);
//            đóng
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
