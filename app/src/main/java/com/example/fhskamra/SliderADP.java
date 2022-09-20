package com.example.fhskamra;

import android.view.FrameMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.slider.Slider;
import com.google.firebase.database.logging.AndroidLogger;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.lang.reflect.Array;
import java.security.cert.X509CRLEntry;

import javax.security.cert.X509Certificate;

public class SliderADP extends SliderViewAdapter<SliderADP.Holder> {
    int[] images;
    public SliderADP(int[] images){
        this.images=images;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
       View view= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.image_slider,parent,false);
       return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        viewHolder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageslider_view);
        }
    }
}
