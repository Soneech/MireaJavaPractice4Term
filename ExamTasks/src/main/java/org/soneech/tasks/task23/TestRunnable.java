package org.soneech.tasks.task23;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i += 10) {
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
