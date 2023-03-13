package org.soneech.practice8.observer;

import java.util.ArrayList;
import java.util.List;

public class CatsJournal implements Observable {
    private List<Observer> readers;
    private String news;

    public CatsJournal() {
        readers = new ArrayList<>();
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    public String getNews() {
        return news;
    }

    public List<Observer> getReaders() {
        return readers;
    }

    @Override
    public void registerObserver(Observer observer) {
        readers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        readers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer reader: readers) {
            reader.update(news);
        }
    }
}
