package baitap5;

public class GuessANumberRunnable implements Runnable {
    private int guessNumber;
    private int count = 0;

    public GuessANumberRunnable(int guessNumber) {
        this.guessNumber = guessNumber;
    }
    @Override
    public void run() {
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(Thread.currentThread().getName() + " guess number " + randomNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (randomNumber != guessNumber);
        System.out.println(Thread.currentThread().getName() + " da doan ra so " + guessNumber + " trong " + count + " lan dem");
    }
}
