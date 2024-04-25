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

    public ArticleAdapter(List<NewsArticle> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_view, parent, false);
        return new NewsArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        NewsArticle newsArticle = newsArticles.get(position);
        holder.heading.setText(newsArticle.heading);
        holder.snippet.setText(newsArticle.snippet);
        holder.image.setImageResource(newsArticle.imageId);
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