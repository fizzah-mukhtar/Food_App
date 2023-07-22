package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button lgin;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lgin = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        lgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username == username && password == password)
                {
                Intent li = new Intent(Login.this,MainActivity.class);
                startActivity(li);
            }
                else if(username == null && password == null)
                {
                     Toast.makeText(getApplicationContext(),"fill all the required fields!!",Toast.LENGTH_LONG).show();
                }

        }
        });
    }
}