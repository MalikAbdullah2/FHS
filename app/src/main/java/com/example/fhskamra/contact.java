package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class contact extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        bottomNavigationView=findViewById(R.id.bottomnav_visitor2);
        bottomNavigationView.setSelectedItemId(R.id.nav_contact_visitor);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_contact_visitor:
                        return true;
                    case R.id.nav_complaint_visitor:
                        Intent b=new Intent(getApplicationContext(), complaint.class);
                        overridePendingTransition(0,0);
                        startActivity(b);
                        return true;
                    case R.id.nav_home_visitor:
                        Intent c=new Intent(getApplicationContext(), visitor2.class);
                        overridePendingTransition(0,0);
                        startActivity(c);
                        return true;
                    case R.id.navw_aboutus_visitor:
                        Intent t=new Intent(getApplicationContext(), aboutus.class);
                        overridePendingTransition(0,0);
                        startActivity(t);
                        return true;
                }
                return false;
            }
        });

    }
}