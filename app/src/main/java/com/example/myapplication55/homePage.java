package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {

    Button con_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        con_btn = findViewById(R.id.con_btn);

        con_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(homePage.this,introPage.class);
                startActivity(i);
            }
        });
    }
}