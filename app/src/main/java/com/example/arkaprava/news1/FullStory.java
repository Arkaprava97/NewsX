package com.example.arkaprava.news1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class FullStory extends AppCompatActivity {

    private WebView webView;
    ProgressDialog progressDialog;
    String url="";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);
        progressDialog=new ProgressDialog(FullStory.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.loadingMessage));
        webView = findViewById(R.id.fullstory);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            url=bundle.getString("link");
            webView.setWebViewClient(new webViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
            setTitle(url);
        }
    }
    public class webViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressDialog.show();
            progressDialog.setCancelable(false);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.open_chrome,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.openChrome:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if(url.equals("")){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.ErrorMsg),
                            Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
