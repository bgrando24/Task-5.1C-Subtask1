package com.example.task_51c_subtask1;

public class NewsArticle {
    public int id;
    public String heading;
    public String snippet;
    public String content;
    public int imageId;

//    constructor
    public NewsArticle(int id, String heading, String snippet, String content, int imageId) {
        this.id = id;
        this.heading = heading;
        this.snippet = snippet;
        this.content = content;
        this.imageId = imageId;
    }
}
