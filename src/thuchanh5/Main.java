package thuchanh5;

public class Main {
    public static void main(String[] args) {
        CountDownRunnable countDownRunnable = new CountDownRunnable();
        Thread thread = new Thread(countDownRunnable);
        thread.start();
    }
}
