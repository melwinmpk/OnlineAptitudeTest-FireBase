package com.mpk.melwin.firebaseauthdemo;

/**
 * Created by Melwin on 3/28/2017.
 */

public class Question {
    String questionID;

    String question0;
    String opa0;
    String opb0;
    String opc0;
    String opd0;
    String answer0;
    String userans0;
    public Question(){

    }

    public Question(String questionID, String question0, String opa0, String opb0, String opc0, String opd0, String answer0) {
        this.questionID = questionID;
        this.question0 = question0;
        this.opa0 = opa0;
        this.opb0 = opb0;
        this.opc0 = opc0;
        this.opd0 = opd0;
        this.answer0 = answer0;
    }

    public void setAnswer0(String answer0) {
        this.answer0 = answer0;
    }

    public String getUserans0() {
        return userans0;
    }



    public String getQuestionID() {
        return questionID;
    }

    public String getQuestion0() {
        return question0;
    }

    public String getOpa0() {
        return opa0;
    }

    public String getOpb0() {
        return opb0;
    }

    public String getOpc0() {
        return opc0;
    }

    public String getOpd0() {
        return opd0;
    }

    public String getAnswer0() {
        return answer0;
    }
}
