package com.example.arkaprava.news1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class FullStory extends AppCompatActivity {

    private TextView Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);

        Desc = (TextView) findViewById(R.id.message);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            int itemposition=bundle.getInt("position");
           // Article currentArticle=
        }
    }

}
