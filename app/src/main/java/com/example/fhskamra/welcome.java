package com.example.fhskamra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity implements View.OnClickListener {
Button btnlogin,btnguest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnlogin=findViewById(R.id.btn_login_welcome);
        btnguest=findViewById(R.id.btn_guest_welcome);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_welcome:
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                break;
            case R.id.btn_guest_welcome:
                Intent j=new Intent(getApplicationContext(),visitor2.class);
                startActivity(j);
                break;
        }

    }
}