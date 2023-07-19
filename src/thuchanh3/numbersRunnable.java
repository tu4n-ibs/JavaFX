package thuchanh3;

public class numbersRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}
