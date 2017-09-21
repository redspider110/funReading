package com.ymzs.funreading.model;

/**
 * Created by xumingtao on 2017/9/20.
 */

public class Photo {
    private Long id;
    private String title;
    private String titleImageUrl;
    private String author;
    private String authorIconUrl;
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorIconUrl() {
        return authorIconUrl;
    }

    public void setAuthorIconUrl(String authorIconUrl) {
        this.authorIconUrl = authorIconUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleImageUrl='" + titleImageUrl + '\'' +
                ", author='" + author + '\'' +
                ", authorIconUrl='" + authorIconUrl + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
