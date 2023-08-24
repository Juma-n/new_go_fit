package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose extends AppCompatActivity {

    Button loss , over , api_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        loss = findViewById(R.id.loss);
        over = findViewById(R.id.over);
        api_btn = findViewById(R.id.api_btn);


        loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(choose.this,loss.class);
                startActivity(i);

            }
        });


        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(choose.this,over.class);
                startActivity(i);
            }
        });

        api_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(choose.this,apiActivity.class);
                startActivity(i);
            }
        });

    }
}