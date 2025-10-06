package com.demo.demo;

public class Q3_SingletonMain {
    public static void main(String[] args) {
        // Create multiple threads to test the thread-safe singleton
        Runnable task = () -> {
            Q3_Singleton instance = Q3_Singleton.getInstance();
            instance.showMessage();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
