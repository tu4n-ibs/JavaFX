package baitap4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mot so nguyen de cac thread doan: ");
        int number = sc.nextInt();
        GuessANumberThread guessANumberThread1 = new GuessANumberThread(number);
        GuessANumberThread guessANumberThread2 = new GuessANumberThread(number);

        guessANumberThread1.setName("thread 1");
        guessANumberThread2.setName("thread 2");

        guessANumberThread1.start();
        guessANumberThread2.start();
    }
}
