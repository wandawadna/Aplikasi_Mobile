package com.example.projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText Inputusername1,Inputemail1,Inputpw1;
    String username1,email1,pw1;
    Button register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        Inputusername1 = findViewById(R.id.username);
        Inputemail1 = findViewById(R.id.email);
        Inputpw1 = findViewById(R.id.pw);
        register = findViewById(R.id.register1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(RegisterActivity.this, LogInActivity.class));
                regist();
            }
        });
    }

    private void regist() {
//        username1 = Inputusername1.getText().toString();
        email1 = Inputemail1.getText().toString();
        pw1 = Inputpw1.getText().toString();

        mAuth.createUserWithEmailAndPassword(email1,pw1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LogInActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this, "Registrasi gagal, soalnya tergantung MUKA!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
        startActivity(intent);
    }
}