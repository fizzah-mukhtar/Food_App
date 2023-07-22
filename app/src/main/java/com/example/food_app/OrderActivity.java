package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.food_app.Adaptors.MainAdaptor;
import com.example.food_app.Adaptors.OrdersAdaptor;
import com.example.food_app.Models.MainModel;
import com.example.food_app.Models.OrdersModel;
import com.example.food_app.databinding.ActivityFoodAppBinding;
import com.example.food_app.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getorders();


        OrdersAdaptor adaptor = new OrdersAdaptor(list,this);
        binding.orderRecyclerview.setAdapter(adaptor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);
    }
}