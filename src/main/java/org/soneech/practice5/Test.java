package org.soneech.practice5;

public class Test {  // Task: implementation of singleton pattern in three ways
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                LazySingleton singleton = LazySingleton.getInstance();
                System.out.println(singleton.hashCode());
            });
            thread.start();
        }

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        DemandHolderSingleton demandHolderSingleton = DemandHolderSingleton.getInstance();
    }
}
