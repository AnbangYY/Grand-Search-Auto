package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.CarBST;
import com.example.a2100assignment.Exp;
import com.example.a2100assignment.ManufacturerExp;
import com.example.a2100assignment.Node;
import com.example.a2100assignment.ParseAdapter;
import com.example.a2100assignment.PriceExp;
import com.example.a2100assignment.QueryParser;
import com.example.a2100assignment.QueryTokenizer;
import com.example.a2100assignment.R;
import com.example.a2100assignment.SpeedExp;
import com.example.a2100assignment.TypeExp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SmartSearchActivity extends AppCompatActivity {

    private ArrayList<Car> GTAcars = new ArrayList<>();
    private List sortedResult;
    private ArrayList<Car> result = new ArrayList<>();
    private Node treeCut ;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private ParseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_search);

        recyclerView = findViewById(R.id.result);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView = findViewById(R.id.smartSearchView);


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

        //create a BST for all data
        final CarBST carTree = new CarBST();
        for (Car c:GTAcars
             ) {
            carTree.insert(c);
        }

        adapter = new ParseAdapter(result, SmartSearchActivity.this);
        recyclerView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                QueryParser queryParser = new QueryParser(query);
                ManufacturerExp m = queryParser.parseManufacturer();
                TypeExp t = queryParser.parseType();
                SpeedExp s = queryParser.parseSpeed();
                PriceExp p = queryParser.parsePrice();

                sortedResult = GTAcars; //result with no match
//
//                if(p.price!=0){
//
//
//                    if(p.compare){
//                        treeCut = carTree.greaterCut(new Car("", "", 0, p.price, "", ""));
//                    }else{
//                        treeCut = carTree.smallerCut(new Car("", "", 0, p.price, "", ""));
//                    }
//                }
//                CarBST cuttedTree = new CarBST(treeCut);
//                sortedResult = cuttedTree.generateList();

//                if(s.speed!=0){
//                    if(s.compare) {
//                        for (int i=0; i<sortedResult.size(); i++) {
//                            Car c = (Car)sortedResult.get(i);
//                            if (c.getPrice()>s.speed){
//                                sortedResult = sortedResult.subList(i, sortedResult.size());
//                                break;
//                            }
//                        }
//                    }
//
//                }

                if(!m.manufacturerName.equals("")||!t.type.equals("")){
                    List dup = sortedResult;

//                    sortedResult.clear();
//                    for (Object o:dup
//                         ) {
//                        Car c = (Car)o;
//                        if(c.getManufacturer().toLowerCase().equals(m.manufacturerName)||c.getType().toLowerCase().equals(c.getType())){
//                            sortedResult.add(o);
//                        }
//                    }
                }

                if(sortedResult.size()>0)
                for (Object o:sortedResult
                     ) {
                    Car c = (Car)o;
                    result.add(c);
                }
                adapter.notifyDataSetChanged();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        }

        );



    }




}