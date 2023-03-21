package org.soneech.practice5;

public class DemandHolderSingleton {  // Bill Pugh, "Initialization on Demand Holder"
    private DemandHolderSingleton() {}

    private static class SingletonHolder {
        private final static DemandHolderSingleton instance = new DemandHolderSingleton();
    }

    public static DemandHolderSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
