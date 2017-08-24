package com.ymzs.funreading.model;

/**
 * Created by xumingtao on 2017/8/23.
 */

public class Fun {
    private String mAuthor;
    private long mTime;
    private String mContent;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long mTime) {
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
