package com.example.a2100assignment.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoadingActivity extends MainActivity {
    private static int TIME_OUT = 4000; //Time to launch the another activity
    private ArrayList<Car> GTAcars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
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
        for (int i = 0; i < GTAcars.size(); i++) {
            if (GTAcars.get(i).isPromotedItem()) {
                Intent promote = new Intent(LoadingActivity.this, PromoteActivity.class);
                startActivity(promote);
            }
        }
        final View myLayout = findViewById(R.id.startscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
};
