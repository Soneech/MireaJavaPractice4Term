package org.soneech.practice4;

public class Main {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(3);

        myExecutorService.execute(() -> {
            try {
                Thread.sleep(200);
                System.out.println("Выведется вторым");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        myExecutorService.execute(() -> {
            try {
                Thread.sleep(250);
                System.out.println("Выведется третьим");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        myExecutorService.execute(() -> System.out.println("Выведется первым"));
        myExecutorService.shutdown();
    }
}
