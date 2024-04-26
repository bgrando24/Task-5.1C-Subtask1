package com.example.task_51c_subtask1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.NewsArticleViewHolder> {

    private List<NewsArticle> newsArticles;
    private boolean isTopStories;
    private OnItemClickListener listener;

//    public ArticleAdapter(List<NewsArticle> newsArticles, boolean isTopStories) {
//        this.newsArticles = newsArticles;
//        this.isTopStories = isTopStories;
//    }

//    for fragment navigation when article is clicked
    public interface OnItemClickListener {
        void onItemClick(NewsArticle article);
    }

    public ArticleAdapter(List<NewsArticle> newsArticles, boolean isTopStories, OnItemClickListener listener) {
        this.newsArticles = newsArticles;
        this.isTopStories = isTopStories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isTopStories) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_stories_recycler_view, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_view, parent, false);
        }
        return new NewsArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        NewsArticle newsArticle = newsArticles.get(position);
        holder.heading.setText(newsArticle.heading);
        if (holder.snippet != null) {
            holder.snippet.setText(newsArticle.snippet != null ? newsArticle.snippet : "");
        }
        holder.image.setImageResource(newsArticle.imageId);

        // Step 3: When an item is clicked, call the interface method
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(newsArticle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public static class NewsArticleViewHolder extends RecyclerView.ViewHolder {
        TextView heading;
        TextView snippet;
        ImageView image;

        public NewsArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.articleHeadingTextView);
            snippet = itemView.findViewById(R.id.articleSnippetTextView);
            image = itemView.findViewById(R.id.articleImageView);
        }
    }

}