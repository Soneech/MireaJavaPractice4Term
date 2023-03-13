package org.soneech.practice8.observer;

public interface Observable {  // or subject
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
