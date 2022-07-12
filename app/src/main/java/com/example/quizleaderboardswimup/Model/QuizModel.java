package com.example.quizleaderboardswimup.Model;

public class QuizModel {
    private String quizID;
    private int topscore;
    private int time;

    public QuizModel(String quizID, int topscore, int time) {
        this.quizID = quizID;
        this.topscore = topscore;
        this.time = time;
    }

    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public int getTopscore() {
        return topscore;
    }

    public void setTopscore(int topscore) {
        this.topscore = topscore;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

