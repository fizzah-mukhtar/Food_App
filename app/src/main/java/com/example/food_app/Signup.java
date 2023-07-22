package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    Button sgup;
    EditText username;
    EditText email;
    EditText password;
    EditText confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sgup = (Button) findViewById(R.id.signup);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);

        sgup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent su = new Intent(Signup.this,MainActivity.class);
                startActivity(su);
            }
        });
    }
}