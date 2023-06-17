package org.soneech.question29;

public class WaitNotifyExample {
    private static int result = 0;
    private static volatile boolean ready = false;

    public static void main(String[] args) {
        Object lock = new Object();

        Runnable producer = () -> {
            synchronized (lock) {
                result = 42;
                ready = true;
                lock.notifyAll();
            }
        };

        Runnable reader = () -> {
            try {
                synchronized (lock) {
                    if (!ready) {
                        lock.wait();
                    }
                    System.out.println(result);
                }
            } catch (InterruptedException ex) {
                // завершение потока
            }
        };

        new Thread(reader).start();
        new Thread(producer).start();
    }
}
