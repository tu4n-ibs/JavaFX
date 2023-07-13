package com.example.quanlythongtin;

public class Student {
   private int id;
   private String name;
   private String Class;
   private String gender;
   private String address;
   private int score;

    public Student(int id, String name, String Class, String gender, String address, int score) {
        this.id = id;
        this.name = name;
        this.Class = Class;
        this.gender = gender;
        this.address = address;
        this.score = score;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasS() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
