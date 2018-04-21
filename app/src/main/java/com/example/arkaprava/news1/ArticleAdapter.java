package com.example.arkaprava.news1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    private  static  final String LOG_TAG=ArticleAdapter.class.getSimpleName();
    public ArticleAdapter(Activity context, ArrayList<Article> articleList)
    {
        super(context,0,articleList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.story_item,parent,false);
        }
        Article currentArticle= getItem(position);
        TextView authorTextView = listItemView.findViewById(R.id.author);
        TextView titleTextView = listItemView.findViewById(R.id.title);
        TextView descTextView = listItemView.findViewById(R.id.description);
        TextView timeTextView = listItemView.findViewById(R.id.TimeOfPublish);
        authorTextView.setText(currentArticle.getAuthor());
        titleTextView.setText(currentArticle.getTitle());
        descTextView.setText(currentArticle.getDescription());
        timeTextView.setText(currentArticle.getTime());
        return listItemView;
    }
}
