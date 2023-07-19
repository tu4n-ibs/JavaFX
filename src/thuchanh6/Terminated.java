package thuchanh6;

public class Terminated {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
