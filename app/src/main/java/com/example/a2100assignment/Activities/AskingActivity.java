package com.example.a2100assignment.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a2100assignment.R;

public class AskingActivity extends AppCompatActivity {
    Button btn;
    Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);
        final View myLayout = findViewById(R.id.asking);
        btn = findViewById(R.id.backask);
        bttn = findViewById(R.id.askup);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AskingActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(AskingActivity.this, "Your Questions are Uploading", Toast.LENGTH_SHORT).show();




            }
        });
    }}