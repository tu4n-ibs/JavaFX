package baitap3;

public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public synchronized void run() {
        for (int i = 2; i <= 1000; i++) {
            if (kiemTra(i)) {
                System.out.print("optim: " + i + "\n");
            }
        }
    }

    public boolean kiemTra(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
