package thuchanh6;

public class Blocked {
    public static synchronized void commonResource() {
        for (int i = 0; i < 100000; i++) {

        }
    }
}

class Blocked1 extends Thread {
    @Override
    public void run() {
        Blocked.commonResource();
    }
}

class Main {
    public static void main(String[] args) {
        Blocked1 blocked = new Blocked1();
        Blocked1 blocked1 = new Blocked1();

        blocked.start();
        blocked1.start();

        System.out.println(blocked.getName() + ": " + blocked.getState());
        System.out.println(blocked1.getName() + ": " + blocked1.getState());
    }
}
