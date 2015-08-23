package com.example.gigigo.demofut52.beans;

/**
 * Created by Davis on 6/30/15.
 */
public class News_Beans {

    private String id_new, title_new, url_img_news, news_description,content_new;

    public News_Beans(String id_new, String title_new, String url_img_news, String news_description, String content_new) {
        this.id_new = id_new;
        this.title_new = title_new;
        this.url_img_news = url_img_news;
        this.news_description = news_description;
        this.content_new = content_new;
    }

    public String getId_new() {

        return id_new;
    }

    public void setId_new(String id_new) {
        this.id_new = id_new;
    }

    public String getTitle_new() {
        return title_new;
    }

    public void setTitle_new(String title_new) {
        this.title_new = title_new;
    }

    public String getUrl_img_news() {
        return url_img_news;
    }

    public void setUrl_img_news(String url_img_news) {
        this.url_img_news = url_img_news;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getContent_new() {
        return content_new;
    }

    public void setContent_new(String content_new) {
        this.content_new = content_new;
    }
}
