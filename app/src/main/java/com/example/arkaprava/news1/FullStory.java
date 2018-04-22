package com.example.arkaprava.news1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class FullStory extends AppCompatActivity {

    private WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);

        mwebView = (WebView) findViewById(R.id.fullstory);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String url=bundle.getString("link");
            WebSettings webSettings = mwebView.getSettings();
            //improve webView performance
            mwebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            mwebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mwebView.getSettings().setAppCacheEnabled(true);
            mwebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setSaveFormData(true);
            webSettings.setEnableSmoothTransition(true);


            mwebView.loadUrl(url);
            //force links open in webview only
            mwebView.setWebViewClient(new WebViewClient());
        }
    }

}
