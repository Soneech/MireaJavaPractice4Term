package org.soneech.practice8.observer;

public class Reader implements Observer {
    private String nickName;
    private String news;

    public Reader(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNews() {
        return news;
    }

    @Override
    public void update(String news) {
        this.news = news;
        System.out.println("reader " + nickName + " found out news: " + news);
    }
}
