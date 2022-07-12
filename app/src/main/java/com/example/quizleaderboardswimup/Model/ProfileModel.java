package com.example.quizleaderboardswimup.Model;

public class ProfileModel {
    private String name;
    private String emil;
    private String phone;
    private int bookMarksCount;

    public ProfileModel(String name, String emil, String phone, int bookMarksCount) {
        this.name = name;
        this.emil = emil;
        this.phone = phone;
        this.bookMarksCount = bookMarksCount;
    }

    public int getBookMarksCount() {
        return bookMarksCount;
    }

    public void setBookMarksCount(int bookMarksCount) {
        this.bookMarksCount = bookMarksCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }
}
