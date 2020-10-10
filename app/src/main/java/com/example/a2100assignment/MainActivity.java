package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String[] mStrs = { "qq", "audi", "benz"};
     SearchView mySearchView;
     ListView myListView;
     ArrayAdapter adapter;
     ArrayList CUS_LIST_TYPE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        myListView.setAdapter(adapter);
        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.equals(query)) {
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
    }}