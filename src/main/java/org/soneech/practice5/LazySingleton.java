package org.soneech.practice5;

public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}
