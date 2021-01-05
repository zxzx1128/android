package com.example.myhealth.bean;

import java.io.Serializable;

public class FoodBean implements Serializable {
    private String title;
    private String calorie;
    private String notmatch;
    private String desc;
    private int picId;

    public FoodBean(String title, String calorie, String notmatch, String desc, int picId) {
        this.title = title;
        this.calorie = calorie;
        this.notmatch = notmatch;
        this.desc = desc;
        this.picId = picId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getNotmatch() {
        return notmatch;
    }

    public void setNotmatch(String notmatch) {
        this.notmatch = notmatch;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
