package baitap3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread threadLazy = new Thread(lazyPrimeFactorization);
        Thread threadOp = new Thread(optimizedPrimeFactorization);

        threadLazy.start();
        threadOp.start();

        threadLazy.join();
        threadOp.join();

    }
}
