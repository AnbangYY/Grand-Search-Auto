package com.example.a2100assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.Buffer;
import java.security.CryptoPrimitive;
import java.util.ArrayList;
import java.io.File;

import static junit.framework.TestCase.assertEquals;

import static junit.framework.TestCase.assertEquals;

public class MainActivity extends AppCompatActivity {

    //private String[] mStrs = { "qq", "audi", "benz"};
    SearchView mySearchView;
    ListView myListView;
    ArrayAdapter adapter;

    String path = "C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\Resources\\JsonFiles\\GTACars.json";


    ArrayList<Car> carCollection = new ArrayList<>();
    ArrayList<String> carname = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            InputStream t = getApplicationContext().getAssets().open("GTACars.json");
            BufferedReader b = new BufferedReader(new InputStreamReader(t, "UTF-8"));
            JsonReader jsonReader = new JsonReader(b);
            Gson gson = new Gson();
            final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
            }.getType();
            carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (Car c:carCollection
             ) {
            carname.add(c.getModel());
        }


        int size = carname.size();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myListView = (ListView) findViewById(R.id.listView);
        ArrayList a = new ArrayList();
        a.add("BMW");
        a.add("Benz");
        a.add("Jaguar");
        a.add(carCollection.size());

        try {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        myListView.setAdapter(adapter);


        myListView.setTextFilterEnabled(true);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                for (String c : carname) {
                    if (c.equals(query)) {
                        adapter.getFilter().filter(query);
                    } else {
                        Toast.makeText(MainActivity.this, "the car that you are looking for is not in the list", Toast.LENGTH_LONG).show();
                    }
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


//    public class RetrieveData extends AsyncTask<Void, Void, Void>{
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//                ArrayList<String> a = getHTMLData();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

//    public static ArrayList<Car> getCarList(File file) {
//        ArrayList carCollection = new ArrayList();
//        Gson gson = new Gson();
//        try {
//            JsonReader jsonReader = new JsonReader(new FileReader(file));
//            final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
//            }.getType();
//            carCollection = gson.fromJson(jsonReader, CUS_LIST_TYPE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return carCollection;
//    }
//
//
//    public ArrayList<String> getHTMLData() throws Exception {
//        ArrayList<String> GTAmanufac = new ArrayList<>();
//        String title = "test";
//
//        Document doc = Jsoup.connect("https://www.gta5rides.com/vehicles/dlc-diamond-casino-resort.cfm").timeout(50000).get();
//        title = doc.title();
//        Elements e = doc.select("div.card-body");
//        int size = e.size();
//
//        for (int i = 0; i < size; i++) {
//            String manufac = e.select("br.card-text")
//                    .eq(i)
//                    .toString();
//            GTAmanufac.add(manufac);
//        }
//        return GTAmanufac;
//    }
}
