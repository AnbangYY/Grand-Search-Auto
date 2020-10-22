package com.example.a2100assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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
import java.util.Timer;
import java.util.TimerTask;

public class PromoteActivity extends AppCompatActivity implements View.OnClickListener {
    private static int TIME_OUT = 2000; //Time to launch the another activity
    private List<Car> promoted = new ArrayList<>();
    private Car show = new Car();
    private ImageView imageView;
    private int recLen = 5;//跳过倒计时提示5秒
    private Button mBtn;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

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

        imageView = findViewById(R.id.imageView_promote);
        Picasso.get().load(show.getImgURL()).into(imageView);

        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() { // UI thread
                    @Override
                    public void run() {
                        recLen--;
                        mBtn.setText("Skip " + recLen);//在控件上显示距离跳转的剩余时间
                        if (recLen < 0) {
                            timer.cancel();
                            mBtn.setVisibility(View.GONE);//倒计时到0隐藏字体
                        }
                    }
                });
            }
        }, 1000, 1000);//等待时间一秒，停顿时间一秒

        //TODO haven't set the layout.

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 5000);
    }

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
}
