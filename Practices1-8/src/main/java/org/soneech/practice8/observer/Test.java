package org.soneech.practice8.observer;

public class Test {
    public static void main(String[] args) {
        CatsJournal catsJournal = new CatsJournal();

        catsJournal.registerObserver(new Reader("Mike"));
        catsJournal.registerObserver(new Reader("Anna"));
        catsJournal.registerObserver(new Reader("Jane"));

        catsJournal.setNews("Cats are really funny and cute... ^-^");
    }
}
