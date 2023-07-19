package thuchanh6.Waiting;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(100);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
