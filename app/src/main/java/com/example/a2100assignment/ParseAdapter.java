package com.example.a2100assignment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.ViewHolder> {


    private ArrayList<Car> cars;
    private Context context;

    public ParseAdapter(ArrayList<Car> cars, Context context){
        this.cars = cars;
        this.context = context;
    }

    @NonNull
    @Override
    public ParseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_car, parent, false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ParseAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.textView1.setText(car.getModel());
        holder.textView2.setText(car.getManufacturer());
        holder.textView3.setText("Speed = "+ car.getSpeed() + " mph");
        holder.textView4.setText("$"+car.getPrice());
        Picasso.get().load(car.getImgURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        public ViewHolder(@NonNull View itemview){
            super(itemview);
            imageView=itemview.findViewById(R.id.imageView8);
            textView1 = itemview.findViewById(R.id.carModel);
            textView2 = itemview.findViewById(R.id.manufacturer);
            textView3 = itemview.findViewById(R.id.speed);
            textView4 = itemview.findViewById(R.id.price);
        }



    }
}