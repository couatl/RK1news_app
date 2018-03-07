package com.example.sharlina.rk1_news_app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;

import ru.mail.park.articlelistlib.Article;

/**
 * Created by sharlina on 07.03.2018.
 */

public class DetailsFragment extends Fragment {
//    public static DetailsFragment newInstance(Article article) {
//        DetailsFragment f = new DetailsFragment();
//
//        Bundle args = new Bundle();
//        args.putSerializable("article", article);
//        f.setArguments(args);
//
//        return f;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        Bundle bundle = getArguments();

        LinearLayout view = new LinearLayout(getActivity());
        view.setOrientation(LinearLayout.VERTICAL);

        ScrollView scroller = new ScrollView(getActivity());
        TextView title = new TextView(getActivity());
        TextView date = new TextView(getActivity());
        TextView content = new TextView(getActivity());

        title.setText(bundle.getString("title"));
        date.setText(bundle.getString("date"));
        content.setText(bundle.getString("content"));

        scroller.addView(content);

        view.addView(title);
        view.addView(date);
        view.addView(scroller);

        return view;
    }
}
