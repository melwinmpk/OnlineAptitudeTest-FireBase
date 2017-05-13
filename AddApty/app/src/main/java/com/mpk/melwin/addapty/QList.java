package com.mpk.melwin.addapty;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Melwin on 3/11/2017.
 */

public class QList extends ArrayAdapter<Question> {
    private Activity context;
    private List<Question> questionList;
public QList(Activity context,List<Question> questionList){
    super(context,R.layout.list_layout,questionList);
    this.context=context;
    this.questionList = questionList;

}

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
       // return super.getView(position, convertView, parent);
        TextView Tquestion = (TextView) listViewItem.findViewById(R.id.textQ);
        TextView TopA = (TextView) listViewItem.findViewById(R.id.textopA);
        TextView TopB = (TextView) listViewItem.findViewById(R.id.textopB);
        TextView TopC = (TextView) listViewItem.findViewById(R.id.textopC);
        TextView TopD = (TextView) listViewItem.findViewById(R.id.textopD);

        Question question = questionList.get(position);

        Tquestion.setText(question.getQuestion0());
        TopA.setText(question.getOpa0());
        TopB.setText(question.getOpb0());
        TopC.setText(question.getOpc0());
        TopD.setText(question.getOpd0());

        return listViewItem;
    }
}
