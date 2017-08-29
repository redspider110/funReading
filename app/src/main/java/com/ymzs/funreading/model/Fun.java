package com.ymzs.funreading.model;

/**
 * Created by xumingtao on 2017/8/23.
 */

public class Fun {
    private String mAuthor;
    private String mTime;
    private String mContent;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    @Override
    public String toString() {
        return "Fun{" +
                "mAuthor='" + mAuthor + '\'' +
                ", mTime=" + mTime +
                ", mContent='" + mContent + '\'' +
                '}';
    }
}
