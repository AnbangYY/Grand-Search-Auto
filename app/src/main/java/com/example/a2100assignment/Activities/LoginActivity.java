package com.example.a2100assignment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2100assignment.R;
import com.example.a2100assignment.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button LoginBut;
    Button Riglog;
    EditText Username, Password;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginBut = findViewById(R.id.LoginBut);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Riglog = findViewById(R.id.Riglog);
        fAuth = FirebaseAuth.getInstance();
    LoginBut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = Username.getText().toString().trim();
            String password = Password.getText().toString().trim();
            if (TextUtils.isEmpty(username)){
                Username.setError("please enter username");
            }
            if (TextUtils.isEmpty(password)){
                Password.setError("please enter password");
            }
            fAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Login complete",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),SmartSearchActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this,"Login fail",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    });
        Riglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }}