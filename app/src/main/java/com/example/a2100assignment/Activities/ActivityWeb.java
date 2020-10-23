package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.a2100assignment.R;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.web);
        webView.loadUrl("https://store.steampowered.com/app/271590/Grand_Theft_Auto_V/");
    }
}