package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class SmartSearchActivity extends AppCompatActivity {

    private ArrayList<Car> GTAcars = new ArrayList<>();
    private List sortedResult;
    private ArrayList<Car> result = new ArrayList<>();
    private Node treeCut ;
    private RecyclerView recyclerView;
    private ParseAdapter adapter;
    private ImageView picView;
    private TextView t21;
    private TextView t22;
    private TextView t23;
    private TextView t24;
    private TextView t25;
    private TextView t26;
    private FloatingActionButton sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_search);


        recyclerView = findViewById(R.id.result);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        picView =findViewById(R.id.imageView13);
        t21 = findViewById(R.id.textView21);
        t22 = findViewById(R.id.textView22);
        t23 = findViewById(R.id.textView23);
        t24 = findViewById(R.id.textView24);
        t25 = findViewById(R.id.textView25);
        t26 = findViewById(R.id.textView26);
        sort = (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        sort.setVisibility(View.INVISIBLE);

        Button go = findViewById(R.id.go);



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


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText= findViewById(R.id.smart);
                String query = editText.getText().toString();
                picView.setVisibility(View.INVISIBLE);
                t21.setVisibility(View.INVISIBLE);
                t22.setVisibility(View.INVISIBLE);
                t23.setVisibility(View.INVISIBLE);
                t24.setVisibility(View.INVISIBLE);
                t25.setVisibility(View.INVISIBLE);
                t26.setVisibility(View.INVISIBLE);

                result.clear();

                QueryParser queryParser1 = new QueryParser(query);
                QueryParser queryParser2 = new QueryParser(query);
                QueryParser queryParser3 = new QueryParser(query);
                QueryParser queryParser4 = new QueryParser(query);
                TypeExp t = queryParser1.parseType();
                ManufacturerExp m = queryParser2.parseManufacturer();
                SpeedExp s = queryParser3.parseSpeed();
                PriceExp p = queryParser4.parsePrice();



                sortedResult = GTAcars; //result with no match
                ArrayList<Car> inverseSortedCars = carTree.bigToSmall();
                ArrayList<Car> sortedCars = carTree.smallToBig();
                ArrayList<Car> cars = new ArrayList<>(inverseSortedCars);
                if(p.price!=0) {
                    if (p.compare) {
                        for (Car c:inverseSortedCars
                             ) {
                            if(c.getPrice()>p.price){
                                result.add(c);
                            }
                        }
                    }else{
                        for (Car c:sortedCars
                             ) {
                            if(c.getPrice()<p.price){
                                result.add(c);
                            }
                        }
                    }

                }


                if(s.speed!=0){
                    if(result.size()>0){
                        cars.clear();
                        cars = new ArrayList<>(result);
                        result.clear();
                    }
                    if(s.compare) {
                        for (Car c:cars
                        ) {
                            if(c.getSpeed()>s.speed){
                                result.add(c);
                            }
                        }
                    }
                    else {
                        for (Car c:cars
                        ) {
                            if(c.getSpeed()<s.speed){
                                result.add(c);
                            }
                        }
                    }
                }

//

                if(!TextUtils.isEmpty(m.manufacturerName)){
                    if(result.size()>0){
                        cars.clear();
                        cars = new ArrayList<>(result);
                        result.clear();
                    }
                    for (Car c:cars
                    ) {
                        if(c.getManufacturer().toLowerCase().equals(m.manufacturerName)){
                            result.add(c);
                        }
                    }
                }
//
                if(!TextUtils.isEmpty(t.type)){
                    if(result.size()>0){
                        cars.clear();
                        cars = new ArrayList<>(result);
                        result.clear();
                    }
                    for (Car c:cars
                    ) {
                        if(c.getType().toLowerCase().equals(t.type)){
                            result.add(c);
                        }
                    }
                    sort.setVisibility(View.INVISIBLE);
                }

                Toast.makeText(getBaseContext(), m.manufacturerName+" "+t.type +" "+ Integer.valueOf(p.price)+" "+Double.valueOf(s.speed),Toast.LENGTH_SHORT).show();


                if(TextUtils.isEmpty(query)) {
                    picView.setVisibility(View.VISIBLE);
                    t21.setVisibility(View.VISIBLE);
                    t22.setVisibility(View.VISIBLE);
                    t23.setVisibility(View.VISIBLE);
                    t24.setVisibility(View.VISIBLE);
                    t25.setVisibility(View.VISIBLE);
                    t26.setVisibility(View.VISIBLE);
                }

                adapter.notifyDataSetChanged();

                if(result.size()!=0){
                    sort.setVisibility(View.VISIBLE);
                }else{
                    sort.setVisibility(View.INVISIBLE);
                }


        }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.reverse(result);
                adapter.notifyDataSetChanged();
            }
        });


}

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}