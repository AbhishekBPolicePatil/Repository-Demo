package com.demo.demo;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Q8_ProducerConsumer {

    private static final int CAPACITY = 10;

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAPACITY);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {

            try {

                for (int i = 0; i < 20; i++) {

                    queue.put(i);

                    System.out.println("Produced: " + i);

                    Thread.sleep(100);

                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            }

        });

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 0; i < 20; i++) {

                    int item = queue.take();

                    System.out.println("Consumed: " + item);

                    Thread.sleep(150);

                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            }

        });

        producer.start();

        consumer.start();

    }

}
