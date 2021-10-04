package com.example.rm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=3000;
    //variables
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Intent intent=new Intent(MainActivity.this,Login.class);
     //   startActivity(intent);
        //animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //hooks
        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        //for new activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Login.class);
              //   startActivity(intent);
              //  finish();
                Pair[] pairs=new Pair[3];

                pairs[0]=new Pair<ImageView,String>(image,"logo_image");
               pairs[1]=new Pair<TextView,String>(logo,"logo_text");
                pairs[2]=new Pair<TextView,String>(slogan,"slogan_text");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent,options.toBundle());
            }
        },SPLASH_SCREEN);


    }
}