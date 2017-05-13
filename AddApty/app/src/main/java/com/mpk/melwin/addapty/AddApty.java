package com.mpk.melwin.addapty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddApty extends AppCompatActivity {

    EditText Question1;
    EditText opa;
    EditText opb;
    EditText opc;
    EditText opd;
    Spinner type1;
    Spinner answers1;
    Button buttonadd,buttonview,buttontest;
    DatabaseReference databaseQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apty);
        databaseQuestion = FirebaseDatabase.getInstance().getReference();

        Question1 = (EditText) findViewById(R.id.textquestion);
        opa = (EditText) findViewById(R.id.textopA);
        opb = (EditText) findViewById(R.id.textopB);
        opc = (EditText) findViewById(R.id.textopC);
        opd = (EditText) findViewById(R.id.textopD);
        type1 = (Spinner) findViewById(R.id.snipperType);
        answers1 = (Spinner) findViewById(R.id.snipperAnswer);
        buttonadd = (Button) findViewById(R.id.buttonAdd);
        buttonview = (Button) findViewById(R.id.buttonView);
        buttontest = (Button) findViewById(R.id.buttonTest);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });

        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(AddApty.this,LQuestion.class));
            }
        });

        buttontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(AddApty.this,TQuestion.class));
            }
        });



    }
    private void addQuestion(){
        String question0 = Question1.getText().toString().trim();
        String opa0 = opa.getText().toString().trim();
        String opb0 = opb.getText().toString().trim();
        String opc0 = opc.getText().toString().trim();
        String opd0 = opd.getText().toString().trim();
        String type0 = type1.getSelectedItem().toString();
        String answers0 = answers1.getSelectedItem().toString();

       // databaseQuestion = FirebaseDatabase.getInstance().getReference(type0);

        if(!TextUtils.isEmpty(question0) && !TextUtils.isEmpty(opa0) && !TextUtils.isEmpty(opb0) && !TextUtils.isEmpty(opc0) && !TextUtils.isEmpty(opd0) && !TextUtils.isEmpty(answers0)){
            String id = databaseQuestion.push().getKey();
            //String id ="Hi";
            Question questionsup = new Question(id,question0,opa0,opb0,opc0,opd0,answers0);
           databaseQuestion.child(type0).child(id).setValue(questionsup);
            Toast.makeText(this,"Question ADDED!!!!!!!",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this, "EVERY PARAMETER MUST BE FILLED", Toast.LENGTH_SHORT).show();
        }
    }


}
