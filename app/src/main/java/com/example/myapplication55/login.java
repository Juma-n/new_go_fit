package com.example.myapplication55;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText emaill,pass;
    Button loginbtn;
    FirebaseAuth mAuth;

    TextView registerL;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(login.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        emaill = findViewById(R.id.emaill);
        pass = findViewById(R.id.pass);
        loginbtn = findViewById(R.id.loginbtn);

        registerL=findViewById(R.id.registerL);


        registerL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),register.class);
                startActivity(i);
                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email,password;
                email=  String.valueOf(emaill.getText().toString());
                password=  String.valueOf(pass.getText().toString());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(login.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(password)){
                    Toast.makeText(login.this,"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(login.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(login.this,MainActivity.class);
                                    startActivity(i);
                                    finish();

                                } else {

                                    Toast.makeText(login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
    }
}