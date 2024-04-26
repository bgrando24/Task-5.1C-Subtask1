package com.example.task_51c_subtask1;

import java.io.Serializable;

public class NewsArticle implements Serializable {
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
