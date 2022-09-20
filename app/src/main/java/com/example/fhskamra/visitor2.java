package com.example.fhskamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Locale;

public class visitor2 extends AppCompatActivity implements View.OnClickListener {
    SliderView sliderView;
    int[] images ={R.drawable.sliderimg1,R.drawable.newlogo,R.drawable.sliderimg3,R.drawable.office,R.drawable.slider4,R.drawable.slidernew1,R.drawable.slidernew2,R.drawable.slidernew3};
    SliderADP sliderADP;
    BottomNavigationView bottomNavigationView;
    TextView newsslider;
    MaterialCardView cvFB,cvLoc,cvWeb,cvProj,cvProcces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor2);
        sliderView=findViewById(R.id.slider_view);
        sliderADP=new SliderADP(images);
        sliderView.setSliderAdapter(sliderADP);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        newsslider=findViewById(R.id.news_slider);
        newsslider.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        newsslider.setSelected(true);
        bottomNavigationView=findViewById(R.id.bottomnav_visitor2);
        cvFB=findViewById(R.id.cv_fb);
        cvProcces=findViewById(R.id.cv_procedures);
        cvProj=findViewById(R.id.cv_projects);
        cvLoc=findViewById(R.id.cv_location);
        cvWeb=findViewById(R.id.cv_website);
        bottomNavigationView.setSelectedItemId(R.id.nav_home_visitor);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home_visitor:
                        return true;
                    case R.id.navw_aboutus_visitor:
                        Intent c=new Intent(getApplicationContext(), contact.class);
                        overridePendingTransition(0,0);
                        startActivity(c);
                        return true;
                    case R.id.nav_complaint_visitor:
                        Intent b=new Intent(getApplicationContext(), complaint.class);
                        overridePendingTransition(0,0);
                        startActivity(b);
                        return true;
                    case R.id.nav_contact_visitor:
                        Intent t=new Intent(getApplicationContext(), contact.class);
                        overridePendingTransition(0,0);
                        startActivity(t);
                        return true;
                    case R.id.cv_projects:
                        Intent p=new Intent(getApplicationContext(),Project.class);
                        startActivity(p);
                    case R.id.cv_procedures:
                        Intent o=new Intent(getApplicationContext(),procedures.class);
                        startActivity(o);
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.cv_fb:
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/FHSKamra/?_rdc=1&_rdr"));
                        startActivity(intent);
                    } catch(Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/appetizerandroid")));
                    }
                    break;
                case R.id.cv_website:
                    String url = "https://fhs-kamra.pk/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    break;
                case R.id.cv_location:
                    Uri gmmIntentUri = Uri.parse("geo:33.857616,72.393265");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);

                    break;

                case R.id.cv_projects:
                    Intent proj=new Intent(getApplicationContext(),Project.class);
                    startActivity(proj);
                    break;
                case R.id.cv_procedures:
                    Intent proc=new Intent(getApplicationContext(),procedure_updated.class);
                    startActivity(proc);
            }
    }
}