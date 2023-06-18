package org.soneech.tasks.task23;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TestRunnable());
        Thread thread2 = new Thread(new TestRunnable());
        Thread thread3 = new Thread(new TestRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
