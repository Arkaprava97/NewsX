package com.example.arkaprava.news1;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

//This class is used to create a volley request
public class HttpConnector {
    private String TAG=HttpConnector.class.getSimpleName();
    private String queryURL;
    private Context context;
    JSONObject jsonresponse;
    private ResponseListener responseListener;
    public interface ResponseListener
    {
        void sendResponse(JSONObject jsonObject);
    }
    public HttpConnector(Context context,String queryURL,ResponseListener responseListener)
    {
        this.queryURL=queryURL;
        this.context=context;
        this.responseListener=responseListener;
    }
    public void makeQuery()
    {
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, queryURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonresponse=response;
                if (responseListener!=null)
                    responseListener.sendResponse(jsonresponse);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                NetworkResponse response= volleyError.networkResponse;
                Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(context, "Ops Your Connection is Wonky!", Toast.LENGTH_SHORT).show();
                //Log.d("Error Response",jsonresponse);
            }
        }
        );
        SingleTon.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
