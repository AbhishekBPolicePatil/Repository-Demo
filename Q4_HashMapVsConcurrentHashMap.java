package com.demo.demo;

import java.util.HashMap;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

public class Q4_HashMapVsConcurrentHashMap {

    public static void main(String[] args) throws InterruptedException {

        // Test with HashMap - may throw ConcurrentModificationException

        Map<Integer, String> hashMap = new HashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {

            executor.execute(() -> {

                for (int j = 0; j < 100; j++) {

                    hashMap.put(j, "Value" + j);

                }

            });

        }

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("HashMap size: " + hashMap.size());

        // Test with ConcurrentHashMap - thread-safe

        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

        ExecutorService executor2 = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {

            executor2.execute(() -> {

                for (int j = 0; j < 100; j++) {

                    concurrentHashMap.put(j, "Value" + j);

                }

            });

        }

        executor2.shutdown();

        executor2.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());

    }

}
