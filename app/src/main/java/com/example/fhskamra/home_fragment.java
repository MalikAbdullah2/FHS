package com.example.fhskamra;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
    public class home_fragment extends Fragment {
    SliderView sliderView;
    int[] images ={R.drawable.sliderimg1,R.drawable.newlogo,R.drawable.sliderimg3,
        R.drawable.office,R.drawable.slider4};
    SliderADP sliderADP;
    public home_fragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_home_fragment, container, true);
      sliderView=view.findViewById(R.id.slider_view);
      sliderADP=new SliderADP(images);
      sliderView.setSliderAdapter(sliderADP);
      sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
      sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
      sliderView.startAutoCycle();
    return view;
    }
    }