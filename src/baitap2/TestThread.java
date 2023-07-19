package baitap2;
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();

        evenThread.start();
        oddThread.start();

        oddThread.join();
        evenThread.join();
    }
}
