package thuchanh1;

import java.util.Random;

import static thuchanh1.Main.DISTANCE;
import static thuchanh1.Main.STEP;

public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        int DISTANCE = 0;
//        int STEP = 0;
        int runStart = 0;
        long startTime = System.currentTimeMillis();

        while (runStart < DISTANCE) {
            int speed = (new Random()).nextInt(20);

            runStart += speed;
            String log = "|";
            int percentTravel = (runStart * 100) / DISTANCE;

            for (int i = 0; i < DISTANCE; i += STEP) {
                if (percentTravel >= i + STEP) {
                    log += "=";
                } else if (percentTravel >= i && percentTravel < i + STEP) {
                    log += "o";
                } else {
                    log += "-";
                }
            }

            log += "|";
            System.out.println("Car: " + this.name + ": " + log + " " + Math.min(DISTANCE, runStart) + " Km");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("car: " + this.name + "broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("car: " + this.name + " finish in " + (endTime - startTime) / 1000 + "s");
    }
}
