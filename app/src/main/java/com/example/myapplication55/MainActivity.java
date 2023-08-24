package com.example.myapplication55;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    TextView tx;
    Button con;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        tx  =findViewById(R.id.textView2);
        con = findViewById(R.id.con);
        user = auth.getCurrentUser();

        if (user == null){

            Intent i = new Intent(getApplicationContext(),login.class);
            startActivity(i);
            finish();
        }else {
            tx.setText(user.getEmail());
        }

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(getApplicationContext(),homePage.class);
                startActivity(i);
                finish();
            }
        });
    }
}