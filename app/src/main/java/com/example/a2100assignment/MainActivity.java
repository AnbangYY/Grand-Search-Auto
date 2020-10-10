package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String[] mStrs = { "qq", "audi", "benz"};
     SearchView mySearchView;
     ListView myListView;
     ArrayAdapter adapter;
     ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Mango");
        list.add("Grapes");
        list.add("Lemon");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        myListView.setAdapter(adapter);
        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.equals(query)) {
                    adapter.getFilter().filter(query);
                }else {
                    Toast.makeText(MainActivity.this,"the car that you are looking for is not in the list",Toast.LENGTH_LONG).show();
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    myListView.setFilterText(newText);
                }else{
                    myListView.clearTextFilter();
                    System.out.println("dsflad");
                }
                return false;
            }
        });

    }
}