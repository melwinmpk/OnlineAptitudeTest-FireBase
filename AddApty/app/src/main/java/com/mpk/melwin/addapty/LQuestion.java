package com.mpk.melwin.addapty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class LQuestion extends AppCompatActivity {

    ListView listViewquestion;
    DatabaseReference databaseQuestion,databaseQuestion1,databaseQuestion2,databaseQuestion3;
    List<Question> Questionlist;
    Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lquestion);
        listViewquestion = (ListView) findViewById(R.id.listviewquestion);
        Questionlist = new ArrayList<>();
        databaseQuestion = FirebaseDatabase.getInstance().getReference("NUMIRICAL");
        databaseQuestion1 = FirebaseDatabase.getInstance().getReference("VERBAL");
        databaseQuestion2 = FirebaseDatabase.getInstance().getReference("NONVERBAL");
        databaseQuestion3 = FirebaseDatabase.getInstance().getReference("MECHANICAL");
        buttonback = (Button) findViewById(R.id.buttonback);

        ////////////////////////////////////////

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LQuestion.this,AddApty.class));
            }
        });




    }

   @Override
    protected void onStart() {
        super.onStart();

                     databaseQuestion.addValueEventListener(new ValueEventListener() { //databaseQuestion
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Questionlist.clear();
                for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                    Question question = Questionsnapshot.getValue(Question.class);
                    Questionlist.add(question);
                }

                QList adapter = new QList(LQuestion.this,Questionlist);
                listViewquestion.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       databaseQuestion1.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
             //  Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   Questionlist.add(question);
               }

               QList adapter = new QList(LQuestion.this,Questionlist);
               listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

       databaseQuestion2.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
              // Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   Questionlist.add(question);
               }

               QList adapter = new QList(LQuestion.this,Questionlist);
               listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

       databaseQuestion3.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
              // Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   Questionlist.add(question);
               }

               QList adapter = new QList(LQuestion.this,Questionlist);
               listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

    }
}
