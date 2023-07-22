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
import com.example.food_app.Models.OrdersModel;
import com.example.food_app.R;
import com.google.android.material.color.HarmonizedColorsOptions;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class OrdersAdaptor extends RecyclerView.Adapter<OrdersAdaptor.ViewHolder>{

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdaptor(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_sample, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final OrdersModel model = list.get(position);
        holder.orderimage.setImageResource(model.getOrderImage());
        holder.Solditemname.setText(model.getSoldItem());
        holder.price.setText(model.getPrice());
        holder.ordernumber.setText(model.getOrderNumber());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, DetailActivity.class);
                it.putExtra("id",model.getOrderNumber());
                it.putExtra("image",model.getOrderImage());
                it.putExtra("price",model.getPrice());
                it.putExtra("description",model.getDescription());
                it.putExtra("name",model.getfoodName());
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView orderimage;
        TextView Solditemname, ordernumber, price,  description;;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderimage = itemView.findViewById(R.id.orderimage);
            Solditemname = itemView.findViewById(R.id.orderitemname);
            ordernumber = itemView.findViewById(R.id.number);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);
        }
    }
}
