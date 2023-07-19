package baitap4;

public class GuessANumberThread extends Thread {

    private int guessNumber;
    private int count = 0;

    public GuessANumberThread(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    @Override
    public void run() {
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(getName() + " guess number " + randomNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (randomNumber != guessNumber);
        System.out.println(getName() + " da doan ra so " + guessNumber + " trong " + count + " lan dem");
    }
}
