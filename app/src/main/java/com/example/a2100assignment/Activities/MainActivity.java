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
        Button userguide;

        ArrayAdapter adapter;

        String path = "C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\Resources\\JsonFiles\\GTACars.json";
        ArrayList<Car> carCollection = new ArrayList<>();
        ArrayList carname = new ArrayList();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            searchByName = (Button)findViewById(R.id.searchByName);
            userguide = (Button)findViewById(R.id.button_helps);
            searchByName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, SearchByNameActivity.class);
                    startActivity(intent);

                }
            });
            userguide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, userguideActivity.class);
                    startActivity(intent);

                }
            });



//            try {
//                InputStream t = getApplicationContext().getAssets().open("GTACars.json");
//                BufferedReader b = new BufferedReader(new InputStreamReader(t, "UTF-8"));
//                JsonReader jsonReader = new JsonReader(b);
//                Gson gson = new Gson();
//                final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
//                }.getType();
//                carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            carname.add(carCollection.size());
//            for (Car c:carCollection
//            ) {
//                carname.add(c.getModel());
//            }


//            int size = carname.size();


////            mySearchView = (SearchView) findViewById(R.id.searchView);
////            myListView = (ListView) findViewById(R.id.listView);
//            ArrayList a = new ArrayList();
//            a.add("BMW");
//            a.add("Benz");
//            a.add("Jaguar");
//            a.add(carCollection.size());
//
//            try {
//                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carname);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            myListView.setAdapter(adapter);


//            myListView.setTextFilterEnabled(true);
//            mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    for (Object c : carname) {
//                        if (c.equals(query)) {
//                            adapter.getFilter().filter(query);
//                        } else {
//                            Toast.makeText(MainActivity.this, "the car that you are looking for is not in the list", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                    return true;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    if (!TextUtils.isEmpty(newText)) {
////                        myListView.setFilterText(newText);
////                    } else {
////                        myListView.clearTextFilter();
////                        System.out.println("dsflad");
////                    }
//                    return false;
//                }
//            });
        }




//        public class RetrieveData extends AsyncTask<Void, Void, Void>{
//            @Override
//            protected Void doInBackground(Void... voids) {
//                try {
//                    ArrayList<String> a = getHTMLData();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }

        public static ArrayList<Car> getCarList(File file) {
            ArrayList carCollection = new ArrayList();
            Gson gson = new Gson();
            try {
                JsonReader jsonReader = new JsonReader(new FileReader(file));
                final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
                }.getType();
                carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return carCollection;
        }

        }



