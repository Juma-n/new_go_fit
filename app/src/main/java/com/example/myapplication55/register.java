package com.example.myapplication55;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class register extends AppCompatActivity {
    EditText emailr,passr;
    Button registerbtn;
    FirebaseAuth mAuth;

    TextView loginR;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(register.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        emailr = findViewById(R.id.emaill);
        passr = findViewById(R.id.pass);
        registerbtn = findViewById(R.id.loginbtn);

        loginR=findViewById(R.id.loginR);


        loginR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
                finish();
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email=  String.valueOf(emailr.getText().toString());
                password=  String.valueOf(passr.getText().toString());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(register.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(password)){
                    Toast.makeText(register.this,"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                    Toast.makeText(register.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(register.this,MainActivity.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });



            }
        });



    }
}