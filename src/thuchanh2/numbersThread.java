package thuchanh2;

public class numbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}
