package com.example.gigigo.demofut52.beans;

/**
 * Created by Davis on 7/2/15.
 */
public class Gallery_Bean {

    private String title_g,url_img;

    public Gallery_Bean(String title_g, String url_img) {
        this.title_g = title_g;
        this.url_img = url_img;
    }

    public String getTitle_g() {

        return title_g;
    }

    public void setTitle_g(String title_g) {
        this.title_g = title_g;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
