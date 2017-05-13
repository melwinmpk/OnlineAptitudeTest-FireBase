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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        firebaseAuth =FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }
        buttonRegister=(Button) findViewById(R.id.buttonRegister);
        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        textViewSignup=(TextView) findViewById(R.id.textView3);

        buttonRegister.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }
    private void regsterUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this,"Plz fill both the fields",Toast.LENGTH_SHORT).show();
            return;

        }
        progressDialog.setMessage("You Are Registering");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Register sucessfully",Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Could not Register sucessfully",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }

                });
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
                regsterUser();
        }
        if(v == textViewSignup){
            startActivity(new Intent(this,LoginActivity.class));

        }
    }
}
