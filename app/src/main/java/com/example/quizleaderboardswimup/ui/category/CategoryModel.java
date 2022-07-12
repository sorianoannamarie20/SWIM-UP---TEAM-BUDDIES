package com.example.quizleaderboardswimup.ui.category;

public class CategoryModel {
    private String docID;
    private String name;
    private int noOfQuiz;

    public CategoryModel(String docID, String name, int noOfQuiz) {
        this.docID = docID;
        this.name = name;
        this.noOfQuiz = noOfQuiz;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfQuiz() {
        return noOfQuiz;
    }

    public void setNoOfQuiz(int noOfQuiz) {
        this.noOfQuiz = noOfQuiz;
    }
}
