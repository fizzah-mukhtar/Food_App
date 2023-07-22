package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.food_app.Adaptors.MainAdaptor;
import com.example.food_app.Models.MainModel;
import com.example.food_app.databinding.ActivityFoodAppBinding;

import java.util.ArrayList;

public class FoodApp extends AppCompatActivity {

    ActivityFoodAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Burger", "5", "Zinger burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "6", "Pizza with extra cheese"));
        list.add(new MainModel(R.drawable.cat_1, "Pizza", "7", "Pizza with extra cheese"));
        list.add(new MainModel(R.drawable.cat_4, "Coldrink", "5", "Coldrink"));
        list.add(new MainModel(R.drawable.cat_5, "Donut", "8", "Donut with extra yummy chocolate"));

        MainAdaptor adaptor = new MainAdaptor(list, this);
        binding.orderRecyclerview.setAdapter(adaptor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(FoodApp.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


