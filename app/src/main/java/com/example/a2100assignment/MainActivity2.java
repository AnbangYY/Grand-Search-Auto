package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ParseAdapter adapter;
    private ArrayList<Car> GTAcars = new ArrayList<>();
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter(GTAcars, this);
        recyclerView.setAdapter(adapter);
        GetCars getCars =new GetCars();
        getCars.execute();

    }

    private class GetCars extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void...voids) {
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

            return null;
        }

        @Override
        protected void onPreExecute() {
           progressBar.setVisibility(View.VISIBLE);
           progressBar.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this,android.R.anim.fade_in));
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Void avoid) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this,android.R.anim.fade_out));
            adapter.notifyDataSetChanged();
        }


    }
}