package com.example.sharlina.rk1_news_app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity {
    boolean landscapeMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ArticleListFragment articleList = new ArticleListFragment();

        transaction.replace(R.id.articles_list, articleList);

        articleList.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                showDetails(article);
            }
        });

        transaction.commit();

        View detailsView = findViewById(R.id.details);
        landscapeMode = detailsView != null && detailsView.getVisibility() == ScrollView.VISIBLE;
    }


    public void showDetails(Article article) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", article.getTitle());
        bundle.putString("date", article.getDate().toString());
        bundle.putString("content", article.getContent());

        detailsFragment.setArguments(bundle);

        if (landscapeMode) {
            transaction.replace(R.id.details, detailsFragment);
        } else {
            transaction.replace(R.id.articles_list, detailsFragment);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    }
