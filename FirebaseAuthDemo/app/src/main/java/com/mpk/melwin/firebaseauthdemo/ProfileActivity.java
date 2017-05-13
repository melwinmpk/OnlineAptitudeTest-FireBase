package com.mpk.melwin.firebaseauthdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    //private FirebaseUser user;
    private TextView textViewUserEmail;
    private Button buttonLogout,buttontest;
    private Button  msendData;
    private DatabaseReference databaseReference,databaseReference1;
    private EditText textname,textaddress;
   // DataSnapshot dataSnapshot;
    UserInformation userInformation;
    TextView mScoreView;
    String user123 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()== null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        userInformation = new UserInformation();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //databaseReference1 = FirebaseDatabase.getInstance().getReference(user.getUid());
       // textname = (EditText) findViewById(R.id.editname);
        //textaddress = (EditText) findViewById(R.id.editaddress);
        msendData = (Button) findViewById(R.id.sendData);
        mScoreView = (TextView) findViewById(R.id.score);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewUserEmail =(TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome "+user.getEmail());
     //  databaseReference1 = FirebaseDatabase.getInstance().getReference(user.getUid());
        user123=user.getEmail().toString().trim();
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttontest = (Button) findViewById(R.id.buttonTest);
        msendData = (Button) findViewById(R.id.sendData);

        buttonLogout.setOnClickListener(this);
        msendData.setOnClickListener(this);

      //  userInformation = dataSnapshot.getValue(UserInformation.class);
        mScoreView.setText(""+userInformation.getScore());

        buttontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ProfileActivity.this,TQuestion.class));
            }
        });

       /* databaseReference1.addValueEventListener(new ValueEventListener() { //databaseQuestion
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //  Questionlist.clear();


                 // String X =  dataSnapshot.getValue();
              //  userInformation.setScore();
                mScoreView.setText(""+userInformation.getScore());


                // TestClass adapter = new TestClass(TQuestion.this,Questionlist);
                // listViewquestion.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

    private void SaveUserInformation(){
       // String name= textname.getText().toString().trim();
       // String address = textaddress.getText().toString().trim();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        int score1 =userInformation.getScore();
        databaseReference.child(user.getUid()).child("SCORE").setValue(userInformation.getScore());
        //databaseQuestion.child(type0).child(id).setValue(questionsup);

        Toast.makeText(this,"Information saved...",Toast.LENGTH_LONG).show();
// Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

       // myRef.setValue("Hello, World!");
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogout){
            userInformation.setScore(0);
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if(v == msendData){
            SaveUserInformation();

        }
        if(v == buttontest){
           // firebaseAuth.signOut();
            finish();
            startActivity(new Intent(ProfileActivity.this,TQuestion.class));
        }
    }
}
