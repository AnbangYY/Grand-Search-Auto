package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.a2100assignment.Car;
import com.example.a2100assignment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PromoteActivity extends AppCompatActivity {
    private static int TIME_OUT = 4000; //Time to launch the another activity
    private Car promoted = new Car();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promote);
        promoted = getIntent().getParcelableExtra("promoted");
        //TODO haven't set the layout.
        imageView = findViewById(R.id.imageView_promote);
        Picasso.get().load(getIntent().getStringExtra("img")).into(imageView);


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
