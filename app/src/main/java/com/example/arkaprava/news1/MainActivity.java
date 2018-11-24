package com.example.arkaprava.news1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpConnector.ResponseListener {

    public static final String API_KEY = "155210972dd84af599b9813843712581";
    ListView articleListview;
    ProgressDialog progressDialog;
    ArticleAdapter articleAdapter;
    String url = "https://newsapi.org/v2/top-headlines?sources=al-jazeera-english&apiKey=" + API_KEY;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.SkyBlue)));
        if(internet_connection()==false)
            setContentView(R.layout.no_connection);
        else
        {
            setContentView(R.layout.activity_main);
            articleListview = (ListView) findViewById(R.id.Storylist);
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            //TextView emptyView = (TextView) findViewById(R.id.empty);
            HttpConnector httpConnector;
            httpConnector = new HttpConnector(getApplicationContext(), url, this);
            httpConnector.makeQuery();
        }
    }

    @Override
    public void sendResponse(JSONObject jsonObject) {
        Log.d(TAG, jsonObject.toString());
        progressDialog.dismiss();
        QueryUtils queryUtils = new QueryUtils(jsonObject);
        if (!queryUtils.isCorrectResponse()) {
            //Add toast for error message later
            return;
        }
        final ArrayList<Article> articleList = queryUtils.extractFeaturesFromJSON();
        articleAdapter = new ArticleAdapter(this, articleList);
        articleListview.setAdapter(articleAdapter);
        //articleAdapter.notifyDataSetChanged();
    }
    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;}
}
