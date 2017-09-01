package com.ymzs.funreading.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by xumingtao on 2017/8/23.
 */

@Entity
public class Fun {
    @Id
    private Long id;
    private String author;
    private String time;
    private String content;
    private int type;

    @Generated(hash = 146934633)
    public Fun(Long id, String author, String time, String content, int type) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.content = content;
        this.type = type;
    }

    @Generated(hash = 1499424344)
    public Fun() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Fun{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
