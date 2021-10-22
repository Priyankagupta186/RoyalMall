package com.example.rm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button callSignUp,goButton;
    ImageView image;
    TextView logoText;
    TextInputLayout username,password;
    FirebaseAuth auth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        callSignUp=findViewById(R.id.signUp_screen);
        image=findViewById(R.id.logo_image);
        logoText=findViewById(R.id.logo_name);
        goButton=findViewById(R.id.goButton);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);


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
               finish();
            //  String userEmail=username.getEditText().getText().toString();
           //   String userPassword=password.getEditText().getText().toString();
             // loginFirebase(userEmail,userPassword);
           }
       });
    }
    public void loginFirebase(String userEmail,String userPassword)
    {
        auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override


                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                         //   Log.d(TAG, "signInWithEmail:success");
                         //   FirebaseUser user = mAuth.getCurrentUser();
                         //   updateUI(user);
                            Intent intent=new Intent(Login.this,Dashboard.class);
                              startActivity(intent);
                              finish();
                        } else {
                            // If sign in fails, display a message to the user.
                          //  Log.w(TAG, "signInWithEmail:failure", task.getException());
                          //  Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //        Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                            Toast.makeText(Login.this,"Email or password id incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}