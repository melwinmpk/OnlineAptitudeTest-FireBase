package com.mpk.melwin.firebaseauthdemo;

/**
 * Created by Melwin on 3/7/2017.
 */

public class UserInformation {

    //public String name;
    //public String address;
    public static int score ;

    public UserInformation(){

    }

    public UserInformation(int score) {
        this.score=score;
    }


    public void setScore(int score) {
        this.score = score;
    }

    public static int getScore() {
        return score;
    }
}
