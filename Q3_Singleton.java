//Q3. Create a program to implement a thread-safe Singleton class using double-checked locking.

package com.demo.demo;

public class Q3_Singleton {

    private static volatile Q3_Singleton instance;

    private Q3_Singleton() {}

    public static Q3_Singleton getInstance() {

        if (instance == null) {

            synchronized (Q3_Singleton.class) {

                if (instance == null) {

                    instance = new Q3_Singleton();

                }

            }

        }

        return instance;

    }

    public void showMessage() {

        System.out.println("Singleton instance created.");

    }

}
