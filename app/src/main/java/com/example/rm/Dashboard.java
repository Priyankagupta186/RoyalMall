package com.example.rm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

//import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
//import com.smarteist.autoimageslider.SliderAnimations;
//import com.smarteist.autoimageslider.SliderView;

public class Dashboard extends AppCompatActivity {
    //SliderView sliderView;
  //  int[] images={
          //  R.drawable.slider1,
          //  R.drawable.slider2,
          //  R.drawable.slider3,
          //  R.drawable.slider4,
          //  R.drawable.slider5
  //  };


    RecyclerView catRecyclerview;
    //Category recyclerview
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
      //  sliderView=findViewById(R.id.image_slider);
       // SliderAdapter sliderAdapter=new SliderAdapter(images);
      //  sliderView.setSliderAdapter(sliderAdapter);
       // sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
       // sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
       // sliderView.startAutoCycle();
        catRecyclerview=findViewById(R.id.rec_category);
        ImageSlider imageSlider=findViewById(R.id.image_slider);
        List<SlideModel> slideModels=new ArrayList<>();
        //slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider6, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider5, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner10, ScaleTypes.CENTER_CROP));

        slideModels.add(new SlideModel(R.drawable.banner12, ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);
        catRecyclerview.setLayoutManager(new LinearLayoutManager(new activity(position,str)));
    }
}