package com.example.hello.day06_recyclerview;

/**
 * Created by 韦作铭 on 2017/12/29.
 */

public class User {
    private int imageId;
    private String content;

    public User(int imageId, String content) {
        this.imageId = imageId;
        this.content = content;
    }
    public User() {

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
