package org.soneech.practice5;

public enum EnumSingleton {
    INSTANCE("Singleton object");

    private final String title;

    EnumSingleton(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
