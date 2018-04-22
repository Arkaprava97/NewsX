package com.example.arkaprava.news1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class FullStory extends AppCompatActivity {

    private WebView Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);

        Desc = (WebView) findViewById(R.id.message);
       /* Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String url=bundle.getString("link");
            Desc.setWebViewClient(new WebViewClient());
            Desc.loadUrl(url);
            Desc.getSettings().setJavaScriptEnabled(true);
        }*/
    }

}
