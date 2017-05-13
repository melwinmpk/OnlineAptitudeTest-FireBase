package com.mpk.melwin.addapty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TQuestion extends AppCompatActivity {

   // ListView listViewquestion;
    DatabaseReference databaseQuestion,databaseQuestion1,databaseQuestion2,databaseQuestion3;
   // List<Question> Questionlist;
    Button buttonback,opA,opB,opC,opD;
    TextView mScoreView,mQuestionView;
    private int mScore=0,mQuestionno=0;
    Question [] Test1= new Question[15];
    int i=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tquestion);
       // listViewquestion = (ListView) findViewById(R.id.testviewquestion);
      //  Questionlist = new ArrayList<>();
        databaseQuestion = FirebaseDatabase.getInstance().getReference("NUMIRICAL");
        databaseQuestion1 = FirebaseDatabase.getInstance().getReference("VERBAL");
        databaseQuestion2 = FirebaseDatabase.getInstance().getReference("NONVERBAL");
        databaseQuestion3 = FirebaseDatabase.getInstance().getReference("MECHANICAL");
        mQuestionView = (TextView) findViewById(R.id.questions);
        mScoreView = (TextView) findViewById(R.id.score);
        buttonback = (Button) findViewById(R.id.Quit);
        opA = (Button) findViewById(R.id.choice1);
        opB = (Button) findViewById(R.id.choice2);
        opC = (Button) findViewById(R.id.choice3);
        opD = (Button) findViewById(R.id.choice4);

        //ABCD1();

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(TQuestion.this,AddApty.class));
            }
        });

    /////////////////////////////////////////////////////////////////////////////////
      // updateQuestion();


            opA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (opA.getText() == Test1[j].getAnswer0()) {
                        mScore++;
                        updateScore(mScore);
                       // Toast.makeText(this,"Question ADDED!!!!!!!",Toast.LENGTH_LONG).show();
                        j++;
                        updateQuestion();

                    }
                    else{
                        j++;
                        updateQuestion();

                    }
                }
            });

            opB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (opB.getText() == Test1[j].getAnswer0()) {
                        mScore++;
                        updateScore(mScore);
                        j++;
                        updateQuestion();

                    }
                    else{
                        j++;
                        updateQuestion();

                    }
                }
            });

            opC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (opC.getText() == Test1[j].getAnswer0()) {
                        mScore++;
                        updateScore(mScore);
                        j++;
                        updateQuestion();

                    }
                    else{
                        j++;
                        updateQuestion();

                    }
                }
            });

            opD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (opD.getText() == Test1[j].getAnswer0()) {
                        mScore++;
                        updateScore(mScore);
                        j++;
                        updateQuestion();

                    }
                    else{
                        j++;
                        updateQuestion();

                    }
                }
            });
            //j++;



        ////////////////////////////////////////////////////////////////////////////


    }

    private void updateQuestion() {
        //Test1[]

        if (j <= i-1) {


            try {
                mQuestionView.setText(Test1[j].getQuestion0());
                opA.setText(Test1[j].getOpa0());
                opB.setText(Test1[j].getOpb0());
                opC.setText(Test1[j].getOpc0());
                opD.setText(Test1[j].getOpd0());

                switch (Test1[j].getAnswer0()) {
                    case "A":
                        Test1[j].setAnswer0(Test1[j].getOpa0());
                        break;
                    case "B":
                        Test1[j].setAnswer0(Test1[j].getOpb0());
                        break;
                    case "C":
                        Test1[j].setAnswer0(Test1[j].getOpc0());
                        break;
                    case "D":
                        Test1[j].setAnswer0(Test1[j].getOpd0());
                        break;
                }

            }catch (ClassCastException e) {
                finish();
                startActivity(new Intent(TQuestion.this, AddApty.class));
            }
        }
            else{
                finish();
                startActivity(new Intent(TQuestion.this, AddApty.class));

            }


    }
    private void updateScore(int mScore){
        mScoreView.setText(""+mScore);
    }

   @Override
    protected void onStart() {
        super.onStart();


       databaseQuestion.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               // Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   //  Questionlist.add(question);
                   Test1[i] = new Question();
                   Test1[i++]=question;
                   if(i==1){
                       try {
                           mQuestionView.setText(Test1[0].getQuestion0());
                           opA.setText(Test1[0].getOpa0());
                           opB.setText(Test1[0].getOpb0());
                           opC.setText(Test1[0].getOpc0());
                           opD.setText(Test1[0].getOpd0());

                           switch (Test1[0].getAnswer0()) {
                               case "A":
                                   Test1[0].setAnswer0(Test1[0].getOpa0());
                                   break;
                               case "B":
                                   Test1[0].setAnswer0(Test1[0].getOpb0());
                                   break;
                               case "C":
                                   Test1[0].setAnswer0(Test1[0].getOpc0());
                                   break;
                               case "D":
                                   Test1[0].setAnswer0(Test1[0].getOpd0());
                                   break;
                           }
                       }catch(ClassCastException e){
                           finish();
                           startActivity(new Intent(TQuestion.this, AddApty.class));

                       }

                   }

               }

               //  TestClass adapter = new TestClass(TQuestion.this,Questionlist);
               // listViewquestion.setAdapter(adapter);

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
                   //  Questionlist.add(question);
                   Test1[i] = new Question();
                   Test1[i++] = question;
               }

               // TestClass adapter = new TestClass(TQuestion.this,Questionlist);
               // listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

       databaseQuestion2.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               //  Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   //  Questionlist.add(question);
                   Test1[i] = new Question();
                   Test1[i++] = question;
               }

               // TestClass adapter = new TestClass(TQuestion.this,Questionlist);
               // listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

       databaseQuestion3.addValueEventListener(new ValueEventListener() { //databaseQuestion
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               //  Questionlist.clear();
               for(DataSnapshot Questionsnapshot: dataSnapshot.getChildren()){

                   Question question = Questionsnapshot.getValue(Question.class);
                   //  Questionlist.add(question);
                   Test1[i] = new Question();
                   Test1[i++] = question;
               }

               // TestClass adapter = new TestClass(TQuestion.this,Questionlist);
               // listViewquestion.setAdapter(adapter);

           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

     //  updateQuestion();


    }

}
