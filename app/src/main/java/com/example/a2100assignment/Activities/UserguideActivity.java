package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2100assignment.R;

public class UserguideActivity extends AppCompatActivity {


    Button accept;
    Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userguide);
        final View myLayout = findViewById(R.id.userguide);
        accept = findViewById(R.id.accept);
        contact = findViewById(R.id.contact);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserguideActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserguideActivity.this, AskingActivity.class);
                startActivity(intent);

            }
        });
    }
}