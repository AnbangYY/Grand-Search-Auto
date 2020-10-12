package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class MainActivity extends AppCompatActivity {



    //private String[] mStrs = { "qq", "audi", "benz"};
     SearchView mySearchView;
     ListView myListView;
     ArrayAdapter adapter;
     ArrayList cars;
     String path = "src/main/Resources/Json Files/carsDetails.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            cars =ObtainCarsFromJson.getCarList(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cars);
        myListView.setAdapter(adapter);
        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (cars.equals(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(MainActivity.this, "the car that you are looking for is not in the list", Toast.LENGTH_LONG).show();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    myListView.setFilterText(newText);
                } else {
                    myListView.clearTextFilter();
                    System.out.println("dsflad");
                }
                return false;
            }
        });
    }

}
