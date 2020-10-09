package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] mStrs = {"bmw", "qq", "audi", "benz"};
    private SearchView mySearchView;
    private ListView myListView;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrs);
        myListView.setAdapter(adapter);
        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mStrs.equals(query)) {
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