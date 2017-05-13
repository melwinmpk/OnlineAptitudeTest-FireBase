package com.mpk.melwin.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

         private Button buttonSigIn;
         private EditText editTextEmail;
         private EditText editTextPassword;
         private TextView textViewSignup;
         private ProgressDialog progressDialog;
         private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
             //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }
        progressDialog = new ProgressDialog(this);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSigIn = (Button) findViewById(R.id.buttonSignin);
        textViewSignup = (TextView) findViewById(R.id.textViewSignUp);

        buttonSigIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
        //buttonSigIn.setOnClickListener(this);
        editTextEmail.setOnClickListener(this);
        editTextPassword.setOnClickListener(this);


    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this,"Plz fill both the fields",Toast.LENGTH_SHORT).show();
            return;

        }
        progressDialog.setMessage("LOADING  !!!!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v == buttonSigIn){
            userLogin();
        }
        if(v ==textViewSignup){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

    }
}
