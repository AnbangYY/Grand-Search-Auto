package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a2100assignment.R;
import com.squareup.picasso.Picasso;

public class PresentCarActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView model;
    private TextView manufacturer;
    private TextView speed;
    private TextView type;
    private TextView price;
    private TextView description;
    private Button back;

    private String detail = "\"The SR was made for only one thing: to make every other sports car look like it's the asthmatic kid in gym. Now get in line.\"";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultdisplay);


        imageView = findViewById(R.id.imageView_vehicle);
        model = findViewById(R.id.textView3);
        manufacturer=findViewById(R.id.textView16);
        speed = findViewById(R.id.textView17);
        type = findViewById(R.id.textView18);
        price = findViewById(R.id.textView19);
        back = findViewById(R.id.btn_back1);
        description = findViewById(R.id.textView20);


        model.setText(getIntent().getStringExtra("model"));
        manufacturer.setText(getIntent().getStringExtra("manufacturer"));
        speed.setText(getIntent().getStringExtra("speed") + " mph");
        type.setText(getIntent().getStringExtra("type"));
        price.setText("$"+getIntent().getStringExtra("price"));
        Picasso.get().load(getIntent().getStringExtra("img")).into(imageView);

        if(getIntent().getStringExtra("model").equals("Oppressor Mk II")){
            description.setText("Extravagant and unpractical, often favored by idiots");
        }else{
        description.setText(detail.replace("SR", getIntent().getStringExtra("model")).replace("sports", getIntent().getStringExtra("type")));}

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PresentCarActivity.this,MainActivity.class);
                startActivity(i);
            }
        });




    }
}