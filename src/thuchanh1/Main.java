package thuchanh1;

public class Main {
    public static int DISTANCE = 100;
    public static int STEP = 2;

    public static void main(String[] args) {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");

        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        Thread thread3 = new Thread(car3);

        System.out.println("distance: 100Km");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

