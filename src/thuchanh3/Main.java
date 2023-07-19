package thuchanh3;

public class Main {
    public static void main(String[] args) {
        numbersRunnable runnable = new numbersRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
