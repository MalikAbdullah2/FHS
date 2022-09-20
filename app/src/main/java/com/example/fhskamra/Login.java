package com.example.fhskamra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btnsignup;
    TextView txtforgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnsignup=findViewById(R.id.btn_register_login);
        txtforgot=findViewById(R.id.txt_forgot_login);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register_login:
                Intent a=new Intent(getApplicationContext(), Signup.class);
                startActivity(a);
                break;
            case R.id.txt_forgot_login:
                Intent b=new Intent(getApplicationContext(), welcome.class);
                startActivity(b);
                break;
        }
    }
}