package com.example.arkaprava.news1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

private JSONObject jsonObject;
String response_code;
private static final String LOG_TAG=QueryUtils.class.getSimpleName();
public  QueryUtils(JSONObject jsonObject)
{
    this.jsonObject=jsonObject;
}
    public boolean isCorrectResponse()
    {
        boolean isCorrect= false;
        try {
             response_code= jsonObject.getString("status");
            if(response_code.equalsIgnoreCase("ok"))
                isCorrect=true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return isCorrect;
    }
    public ArrayList<Article> extractFeaturesFromJSON()
    {
        int i;
        ArrayList<Article> articles= new ArrayList<>();
       // if (TextUtils.isEmpty(jsonObject))
         //   return null;
        try {
           // JSONObject baseJSONResponse=new JSONObject(jsonObject);
            JSONArray articlearray=jsonObject.getJSONArray("articles");
            for (i=0;i<articlearray.length();i++)
            {
                JSONObject object=articlearray.getJSONObject(i);
                String author=object.getString("author");
                author=" - "+author;
                String title=object.getString("title");
                String description = object.getString("description");
                String time= object.getString("publishedAt");
                String link=object.getString("url");
                Article ob=new Article(author,title,description,time,link);
                //if(author!="" || author!=null||description!=null||description!="")
                articles.add(ob);
            }
        }
        catch (JSONException e) {
            Log.e(LOG_TAG, "Error in parsing JSON",e);
        }
        return articles;
    }
}
