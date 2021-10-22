package com.example.rm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button callLogIn,go;
    TextInputLayout email,password,phone,name;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        callLogIn=findViewById(R.id.logIn);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
       // phone=findViewById(R.id.phoneNo);
      //  name=findViewById(R.id.name);
        go=findViewById(R.id.go);
        auth=FirebaseAuth.getInstance();

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
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=email.getEditText().getText().toString();
                String userPassword=password.getEditText().getText().toString();
                signUpFirebase(userEmail,userPassword);
            }
        });
    }
    public void signUpFirebase(String userEmail,String userPassword)
    {
        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // Sign in success, update UI with the signed-in user's information
//                          //  Log.d(TAG, "createUserWithEmail:success");
//                           // FirebaseUser user = mAuth.getCurrentUser();
//                          //  updateUI(user);
                            Toast.makeText(SignUp.this,"Your account is created!",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(SignUp.this,Login.class);
                            startActivity(i);
                            finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUp.this,"Some problem occurred !",Toast.LENGTH_SHORT).show();
                        //e.printStackTrace();
                    }
                });
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                          //  Log.d(TAG, "createUserWithEmail:success");
//                           // FirebaseUser user = mAuth.getCurrentUser();
//                          //  updateUI(user);
//                            Toast.makeText(SignUp.this,"Your account is created!",Toast.LENGTH_SHORT).show();
//                            Intent i=new Intent(SignUp.this,Login.class);
//                            startActivity(i);
//                            finish();
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                           // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                 //   Toast.LENGTH_SHORT).show();
//                           // updateUI(null);
//
//                            Toast.makeText(SignUp.this,"Some problem occurred !",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }
}