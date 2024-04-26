package com.example.task_51c_subtask1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ArticleFragment extends Fragment {

    private static final String ARG_ARTICLE = "article";

    private NewsArticle article;

//    component references
    private ImageView articleFragmentImage;
    private TextView articleFragmentHeading;
    private TextView articleFragmentSnippet;
    private TextView articleFragmentContent;
    private Button articleBackHomeButton;

    public static ArticleFragment newInstance(NewsArticle article) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ARTICLE, article);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            article = (NewsArticle) getArguments().getSerializable(ARG_ARTICLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        // inflate layout
        articleFragmentImage = view.findViewById(R.id.articleFragmentImageView);
        articleFragmentHeading = view.findViewById(R.id.articleFragmentHeading);
        articleFragmentSnippet = view.findViewById(R.id.articleFragmentSnippet);
        articleFragmentContent = view.findViewById(R.id.articleFragmentContent);

        // fill the views with data
        articleFragmentHeading.setText(article.heading);
        articleFragmentSnippet.setText(article.snippet);
        articleFragmentContent.setText(article.content);
        articleFragmentImage.setImageResource(article.imageId);

        return view;
    }
}