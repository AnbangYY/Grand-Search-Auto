package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private String[] mStrs = {"bmw", "qq", "audi", "benz"};
    private SearchView mySearchView;
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    myListView.setFilterText(newText);
                }else{
                    myListView.clearTextFilter();
                }
                return false;
            }
        });

    }
}