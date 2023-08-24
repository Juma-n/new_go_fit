package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class apiActivity extends AppCompatActivity {
    String api="https://jsonplaceholder.typicode.com/photos";
    ArrayList<userModel> allUsersList;
    RecyclerView rcvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        rcvMain=findViewById(R.id.rcvMain);

        rcvMain.setLayoutManager(new LinearLayoutManager(this));
        getData();
        allUsersList=new ArrayList<>();

    }


    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray array =new JSONArray(response);
                            for (int i=0;i<array.length();i++){
                                JSONObject singleObject =array.getJSONObject(i);
                                userModel singleModel = new userModel(
                                        singleObject.getInt("albumId"),
                                        singleObject.getInt("id"),
                                        singleObject.getString("title"),
                                        singleObject.getString("url"),
                                        singleObject.getString("thumbnailUrl")
                                );
                                allUsersList.add(singleModel);
                            }

                            rcvMain.setAdapter(new userAdapter(apiActivity.this,allUsersList));

                            Log.e("api","onResponde: "+allUsersList.size());

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("api","onResponse: "+e.getMessage());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("api","onErrorResponse: "+ error.getLocalizedMessage());
            }
        });

        queue.add(stringRequest);
    }

}