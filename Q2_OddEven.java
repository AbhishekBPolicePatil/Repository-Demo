package com.demo.demo;

public class Q2_OddEven {
    private static final Object lock = new Object();
    private static int number = 1;
    private static final int MAX = 20;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                printNumbers("Odd", true);
            }
        });
        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                printNumbers("Even", false);
            }
        });

        oddThread.start();
        evenThread.start();
    }

    private static void printNumbers(String type, boolean isOdd) {
        synchronized (lock) {
            while (number <= MAX) {
                if ((isOdd && number % 2 == 1) || (!isOdd && number % 2 == 0)) {
                    System.out.println(type + ": " + number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            lock.notify();
        }
    }
}