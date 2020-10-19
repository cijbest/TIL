package com.example.r500;

public class Item {

    String id;
    String name;
    int age;
    String img;
    int grade;

    public Item() {
    }

    public Item(String id, String name, int age, String img, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getImg() {
        return img;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}