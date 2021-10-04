package com.example.rm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    Button callSignUp,goButton;
    ImageView image;
    TextView logoText;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        callSignUp=findViewById(R.id.signUp_screen);
        image=findViewById(R.id.logo_image);
        logoText=findViewById(R.id.logo_name);
        goButton=findViewById(R.id.goButton);


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,SignUp.class);
               // startActivity(intent);
                Pair[] pairs=new Pair[2];

                pairs[0]=new Pair<ImageView,String>(image,"logo_image");
                pairs[1]=new Pair<TextView,String>(logoText,"logo_text");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent,options.toBundle());

            }
        });
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }
}