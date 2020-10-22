package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.File;

import static junit.framework.TestCase.assertEquals;


public class MainActivity extends AppCompatActivity {

        //private String[] mStrs = { "qq", "audi", "benz"};
        SearchView mySearchView;
        EditText searchBox;
        Button searchByName;
        Button smartSearch;

        ArrayAdapter adapter;

        String path = "C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\Resources\\JsonFiles\\GTACars.json";
        ArrayList<Car> carCollection = new ArrayList<>();
        ArrayList carname = new ArrayList();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            searchByName = (Button)findViewById(R.id.searchByName);

            searchByName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, SearchByNameActivity.class);
                    startActivity(intent);

                }
            });
            smartSearch = findViewById(R.id.smartSearch);

            smartSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent =  new Intent(MainActivity.this, SmartSearchActivity.class);
                    startActivity(intent);
                }
            });







        }}



