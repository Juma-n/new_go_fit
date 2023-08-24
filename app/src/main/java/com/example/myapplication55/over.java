package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class over extends AppCompatActivity {

    ImageView food_over , ex_over;
    Button go_over;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);

        food_over = findViewById(R.id.food_over);
        ex_over = findViewById(R.id.ex_over);
        go_over = findViewById(R.id.go_over);

        food_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(over.this,food_over.class);
                startActivity(i);
            }
        });

        ex_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(over.this,ex_over.class);
                startActivity(i);
            }
        });
    }
}