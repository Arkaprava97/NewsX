package com.example.arkaprava.news1;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

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
        final Article currentArticle= getItem(position);
        TextView authorTextView = listItemView.findViewById(R.id.author);
        TextView titleTextView = listItemView.findViewById(R.id.title);
        TextView descTextView = listItemView.findViewById(R.id.description);
        TextView timeTextView = listItemView.findViewById(R.id.TimeOfPublish);
        authorTextView.setText(currentArticle.getAuthor());
        titleTextView.setText(currentArticle.getTitle());
        descTextView.setText(currentArticle.getDescription());
        timeTextView.setText(currentArticle.getTime());
        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),FullStory.class);
                String link = currentArticle.getArticleLink();
                intent.putExtra("link",link);
                getContext().startActivity(intent);
            }
        });
        return listItemView;
    }
}
