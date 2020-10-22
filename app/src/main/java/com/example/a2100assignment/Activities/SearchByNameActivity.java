package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.ParseAdapter;
import com.example.a2100assignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SearchByNameActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ParseAdapter adapter;
    private ArrayList<Car> GTAcars = new ArrayList<>();
    private ArrayList<Car> subs ;
    private ProgressBar progressBar;
    SearchView mySearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        try {
            InputStream t = getApplicationContext().getAssets().open("GTACars.json");
            BufferedReader b = new BufferedReader(new InputStreamReader(t, "UTF-8"));
            JsonReader jsonReader = new JsonReader(b);
            Gson gson = new Gson();
            final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
            }.getType();
            GTAcars = gson.fromJson(jsonReader, CUS_LIST_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        subs = new ArrayList<>(GTAcars);



        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);

        mySearchView = (SearchView) findViewById(R.id.mySearchView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter(GTAcars, SearchByNameActivity.this);
        recyclerView.setAdapter(adapter);


        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ArrayList<Car> emptyList =new ArrayList<>();

                Boolean found = false;
               for(Car c : GTAcars){
                    if(c.getModel().toLowerCase().equals(query)){
                        GTAcars.clear();
                        GTAcars.add(c);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(SearchByNameActivity.this, "here's your car", Toast.LENGTH_LONG).show();
                        found = true;
                        break;

                    }
               }

               if(!found){
                   Toast.makeText(SearchByNameActivity.this, "there is no such car", Toast.LENGTH_LONG).show();
               }

               if(TextUtils.isEmpty(query)){
                   GTAcars = subs;
                   adapter.notifyDataSetChanged();
               }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(TextUtils.isEmpty(newText)){

                    GTAcars = new ArrayList<>(subs);
                    adapter = new ParseAdapter(GTAcars, SearchByNameActivity.this);
                    recyclerView.setAdapter(adapter);

                }

                return false;
            }
        });

        mySearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(SearchByNameActivity.this, "bye", Toast.LENGTH_LONG).show();
                Intent i =new Intent(SearchByNameActivity.this,MainActivity.class);
                startActivity(i);
                return true;
            }
        });







    }

    private class GetCarNames extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void...voids) {

//            for (Car c:GTAcars
//                 ) {
//                names.add(c.getModel());
//            }
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                   try{ Thread.sleep(5000);}catch (Exception e){
                       e.printStackTrace();
                   }
                }
            });

            t.start();
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(SearchByNameActivity.this,android.R.anim.fade_in));
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Void avoid) {
            progressBar.setVisibility(View.GONE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(SearchByNameActivity.this,android.R.anim.fade_out));
        }


    }
}