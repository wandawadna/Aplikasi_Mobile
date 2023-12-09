package com.example.projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class LogInActivity extends AppCompatActivity {
    EditText Inputemail,Inputpw;
    String email,pw;
    Button login;
    TextView signup;
    private FirebaseAuth mAuth;
//private lateinit var auth: FirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
//        auth = Firebase.auth;
        Inputemail = findViewById(R.id.email2);
        Inputpw = findViewById(R.id.passwordET);
        login = findViewById(R.id.buttonLogIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ceklogin();
            }
        });
    }

    private void ceklogin() {
       email = Inputemail.getText().toString();
       pw = Inputpw.getText().toString();

        mAuth.signInWithEmailAndPassword(email,pw)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task){
                    if (task.isSuccessful()){
                        startActivity(new Intent(LogInActivity.this, activity_home.class));
                    }else {
                        Toast.makeText(LogInActivity.this, "Login gagal, email atau password salah!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    public void registrasi(View view) {
        Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
        startActivity(intent);

    }
}