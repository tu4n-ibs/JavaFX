package thuchanh6.Waiting;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread Start");
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        try {
            myRunnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThread End");
    }

}
