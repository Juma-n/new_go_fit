package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class loss extends AppCompatActivity {

    ImageView food_loss , ex_loss;
    Button go_loss , note_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);

        food_loss= findViewById(R.id.food_over);
        ex_loss= findViewById(R.id.ex_over);
        go_loss= findViewById(R.id.go_over);
        note_btn= findViewById(R.id.note_btn);

        food_loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loss.this , com.example.myapplication55.food_loss.class);
                startActivity(i);
            }
        });

        ex_loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loss.this , com.example.myapplication55.ex_loss.class);
                startActivity(i);
            }
        });

        go_loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loss.this , com.example.myapplication55.choose.class);
                startActivity(i);
            }
        });

        note_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loss.this , com.example.myapplication55.note_loss.class);
                startActivity(i);
            }
        });



    }
}