package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PromoteActivity extends AppCompatActivity {
    private static int TIME_OUT = 2000; //Time to launch the another activity
    private List<Car> promoted = new ArrayList<>();
    private Car show = new Car();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promote);
        try {
            InputStream t = getApplicationContext().getAssets().open("PromotedCars.json");
            BufferedReader b = new BufferedReader(new InputStreamReader(t, "UTF-8"));
            JsonReader jsonReader = new JsonReader(b);
            Gson gson = new Gson();
            final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
            }.getType();
            promoted = gson.fromJson(jsonReader, CUS_LIST_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < promoted.size(); i++) {
            if (promoted.get(i).showOrNot()) {
                show = promoted.get(i);
            }
        }
        //TODO haven't set the layout.

        imageView = findViewById(R.id.imageView_promote);
        Picasso.get().load(show.getImgURL()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent car = new Intent(PromoteActivity.this, PresentCarActivity.class);
                car.putExtra("model", show.getModel());
                car.putExtra("manufacturer", show.getManufacturer());
                car.putExtra("speed", show.getSpeed());
                car.putExtra("price", show.getPrice());
                car.putExtra("img", show.getImgURL());

                startActivity(car);
                finish();
            }
        });

        // display it for 4 seconds.
        final View myLayout = findViewById(R.id.promoteCar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(PromoteActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
