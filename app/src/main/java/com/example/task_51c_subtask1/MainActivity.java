package com.example.task_51c_subtask1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ArticleAdapter.OnItemClickListener {

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
//        topStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.TopStories), true);
//        newsStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.NewsStories), false);
        topStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.TopStories), true, this);
        newsStoriesAdapter = new ArticleAdapter(Arrays.asList(AllArticles.NewsStories), false, this);


//        set adapters to recyclers
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);
        newsStoriesRecyclerView.setAdapter(newsStoriesAdapter);

//        set layout managers for recyclers
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        newsStoriesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

//    handles showing the recycler views again when user navigates back from article fragment
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            // Show the RecyclerViews
            topStoriesRecyclerView.setVisibility(View.VISIBLE);
            newsStoriesRecyclerView.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(NewsArticle article) {
        ArticleFragment articleFragment = ArticleFragment.newInstance(article);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, articleFragment)
                .addToBackStack(null)
                .commit();

        // Hide the RecyclerViews
        topStoriesRecyclerView.setVisibility(View.GONE);
        newsStoriesRecyclerView.setVisibility(View.GONE);
    }
}


