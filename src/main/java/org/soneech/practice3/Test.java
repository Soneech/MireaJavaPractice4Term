package org.soneech.practice3;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        firstSyncTest();
        secondSyncTest();
    }

    public static void firstSyncTest() {
        SynchronizedList<Integer> syncList = new SynchronizedList<>();
        List<Integer> list = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                syncList.add(1);
                list.add(1);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                syncList.add(1);
                list.add(1);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("sync-list size: " + syncList.size());
        System.out.println("     list size: " + list.size());

    }

    public static void secondSyncTest() {
        SynchronizedSet<Integer> syncSet = new SynchronizedSet<>();
        Set<Integer> set = new HashSet<>();

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 500; i++) {
               syncSet.add(i);
               set.add(i);
           }
        });

        Thread thread2 = new Thread(() -> {
           for (int i = 500; i < 1000; i++) {
               syncSet.add(i);
               set.add(i);
           }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println(" sync-set size: " + syncSet.size());
        System.out.println("      set size: " + set.size());
    }
}
