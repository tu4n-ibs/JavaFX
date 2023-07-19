package thuchanh6;

public class Runnable extends Thread{
    @Override
    public void run() {
        System.out.println("Thread Start");
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable();
        runnable.start();
        System.out.println(runnable.getState());
    }
}
