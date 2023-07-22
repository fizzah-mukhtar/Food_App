package com.example.food_app.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_app.DetailActivity;
import com.example.food_app.Models.MainModel;
import com.example.food_app.R;

import java.util.ArrayList;

public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.ViewHolder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdaptor(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MainModel model = list.get(position);
        holder.foodimage.setImageResource(model.getImage());
        holder.namebox.setText(model.getFoodName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("foodname",model.getFoodName());
                //intent.putExtra("username",model.getUserName());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("description",model.getDescription());
                intent.putExtra("type", 1);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodimage;
        TextView namebox, price, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodimage = itemView.findViewById(R.id.imageView);
            namebox = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.orderprice);
            description = itemView.findViewById(R.id.description);


        }
    }
}
