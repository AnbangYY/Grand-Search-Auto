package com.example.a2100assignment;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2100assignment.Activities.PresentCarActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.ViewHolder> implements Filterable {


    private ArrayList<Car> cars;
    private Context context;

    private ArrayList<Car> org;

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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Car> results = new ArrayList<Car>();
                if(org == null){
                    org = cars;
                    if(constraint !=null){
                        if(org!=null&org.size()>0){
                            for(final Car c : org){
                                if(c.getModel().toLowerCase().contains(constraint.toString())){
                                    results.add(c);
                                }
                            }
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                cars = (ArrayList<Car>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemview.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Car car = cars.get(position);

            Intent intent = new Intent(context, PresentCarActivity.class);
            intent.putExtra("model", car.getModel());
            intent.putExtra("manufacturer", car.getManufacturer());
            intent.putExtra("type", car.getType());
            intent.putExtra("speed", car.getSpeed());
            intent.putExtra("price", car.getPrice());
            intent.putExtra("img", car.getImgURL());
            context.startActivity(intent);
        }
    }
}
