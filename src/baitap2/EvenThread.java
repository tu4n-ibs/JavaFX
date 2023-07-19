package baitap2;

public class EvenThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
