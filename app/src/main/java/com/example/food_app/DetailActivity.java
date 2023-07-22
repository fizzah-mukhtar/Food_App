package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.databinding.ActivityDetailBinding;

import java.security.PrivateKey;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    ImageView plus;
    ImageView minus;
    TextView quantity;
    EditText username, phone;
    TextView price;
    TextView FoodName, description;

    private String UserName;
    private String PhoneNo;
    private String Foodname;
    private String desc;
    private int Price;
    private int Quantity;
    private int TotalAmount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        plus = (ImageView) findViewById(R.id.plus);
        minus = (ImageView) findViewById(R.id.minus);
        quantity = (TextView) findViewById(R.id.QUNTY);
        username = (EditText) findViewById(R.id.NAME);
        phone = (EditText) findViewById(R.id.PHONE);
        price = (TextView) findViewById(R.id.PRC);
        FoodName = (TextView) findViewById(R.id.FOOD);
        description = (TextView) findViewById(R.id.DESC);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = quantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                quantity.setText(String.valueOf(value));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = quantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                value--;
                quantity.setText(String.valueOf(value));
            }
        });

        if(getIntent().getIntExtra("type", 0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            //final int quantity = Integer.parseInt(getIntent().getStringExtra("quantity"));
            String username = getIntent().getStringExtra("username");
            String description = getIntent().getStringExtra("description");
            String foodname = getIntent().getStringExtra("foodname");


            binding.detailimages.setImageResource(image);
            binding.PRC.setText(String.format("%d", price));
            binding.FOOD.setText(foodname);
            binding.NAME.setText(username);
            binding.DESC.setText(description);
            // binding.quantity.setText(String.format("%d" ,quantity));




            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helper.insertorder(
                            username,
                            binding.PHONE.getText().toString(),
                            price,
                            image,
                            Integer.parseInt(binding.QUNTY.getText().toString()),
                            description,
                            foodname
                    );
                    sendData();




                    if (isInserted)
                    {
                        Toast.makeText(DetailActivity.this, "Data successfully stored. ", Toast.LENGTH_LONG).show();
                    }


                    else
                    {
                        Toast.makeText(DetailActivity.this, "Data not stored. ", Toast.LENGTH_LONG).show();
                    }

                    Intent bill = new Intent(DetailActivity.this,bill.class);
                    startActivity(bill);


                }
            });
        }
        else
        {

        }




    }

    public void sendData() {
        UserName = username.getText().toString().trim();
        PhoneNo = phone.getText().toString().trim();
        Foodname = FoodName.getText().toString().trim();
        desc = description.getText().toString().trim();
        Price = Integer.parseInt(price.getText().toString().trim());
        Quantity = Integer.parseInt(quantity.getText().toString().trim());
        TotalAmount = Price * Quantity;

        Intent data = new Intent(DetailActivity.this,bill.class);
        data.putExtra(bill.NAME,UserName);
        data.putExtra(bill.PHONE,PhoneNo);
        data.putExtra(bill.FOOD,Foodname);
        data.putExtra(bill.DESC,desc);
        data.putExtra(String.valueOf(bill.QUNTY),Quantity);
        data.putExtra(String.valueOf(bill.PRC),Price);


        startActivity(data);

    }
}