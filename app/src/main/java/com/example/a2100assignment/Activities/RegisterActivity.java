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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText Username, Password;
    Button ResigterBut;
    Button Backlog;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        ResigterBut = findViewById(R.id.LoginBut);
        Backlog = findViewById(R.id.Backlog);
        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),SmartSearchActivity.class));
        }
        ResigterBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (TextUtils.isEmpty(username)){
                    Username.setError("please enter username");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Password.setError("please enter password");
                    return;
                }
                if (password.length()<7){
                    Password.setError("too short password");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"register complete",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),SmartSearchActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this,"register fail" +task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        Backlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}