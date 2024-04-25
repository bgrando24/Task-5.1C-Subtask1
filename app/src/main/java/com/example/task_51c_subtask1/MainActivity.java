package com.example.task_51c_subtask1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//    component and object references for use
    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsStoriesRecyclerView;
    private ArticleAdapter topStoriesAdapter;
    private ArticleAdapter newsStoriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        init recycler views
        topStoriesRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        newsStoriesRecyclerView = findViewById(R.id.newsStoriesRecyclerView);

//        init adapters
        topStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.TopStories));
        newsStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.NewsStories));

//        set adapters to recyclers
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);
        newsStoriesRecyclerView.setAdapter(newsStoriesAdapter);

//        set layout managers for recyclers
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        newsStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}