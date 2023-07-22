package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bill extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String PHONE = "PHONE";
    public static final String FOOD = "FOOD";
    public static final String DESC = "DESC";
    public static final int QUNTY = 0;
    public static final int PRC = 0;
    public static final int TO_AMOUNT = 0;

    private TextView username;
    private TextView phone;
    private TextView food;
    private TextView desc;
    private TextView qunty;
    private TextView prc;
    private TextView amount;
    private String name,Phone,Food,Desc;
    private int Qunty,Prc,Amount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        username = findViewById(R.id.NAME);
        phone = findViewById(R.id.PHONE);
        food = findViewById(R.id.FOOD);
        desc = findViewById(R.id.DESC);
        qunty = findViewById(R.id.QUNTY);
        prc = findViewById(R.id.PRC);

        Intent data = getIntent();

        name = data.getStringExtra(NAME);
        Phone = data.getStringExtra(PHONE);
        Food = data.getStringExtra(FOOD);
        Desc = data.getStringExtra(DESC);
        Qunty = data.getIntExtra(String.valueOf(QUNTY),0);
        Prc = data.getIntExtra(String.valueOf(PRC),0);




    }
}