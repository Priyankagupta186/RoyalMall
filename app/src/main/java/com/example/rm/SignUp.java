package com.example.rm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    Button callLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        callLogIn=findViewById(R.id.logIn);
      /*  callLogIn.setOnClickListener(new View.OnClickListener() {
          @Override
         public void onClick(View view) {
          Intent intent=new Intent(SignUp.this,Login.class);
           startActivity(intent);
          finish();

         }
         });*/
        callLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Intent intent=new Intent(SignUp.this,Login.class);
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
                finish();

            }
        });
    }
}