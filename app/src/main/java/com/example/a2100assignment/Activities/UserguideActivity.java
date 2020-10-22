package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.a2100assignment.R;

public class UserguideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userguide);
        final View myLayout = findViewById(R.id.userguide);
    }
}