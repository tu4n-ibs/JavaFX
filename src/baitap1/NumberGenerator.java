package baitap1;

public class NumberGenerator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        Thread thread = new Thread(numberGenerator);
        thread.setPriority(thread.MAX_PRIORITY);
        thread.start();


        Thread thread1 = new Thread(numberGenerator);
        thread1.setPriority(thread.MIN_PRIORITY);
        thread1.start();

        System.out.println("hashCode: " + numberGenerator.hashCode());
    }
}
