package com.example.demo.entity;

/**
 * Created by damei on 19/2/28.
 */
public class Diary {
    private int diaryid;
    private String tag;
    private String date;
    private String location;
    private String mood;
    private String content;
    private String isprivate;

    public String getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(String isprivate) {
        this.isprivate = isprivate;
    }

    public int getDiaryid() {
        return diaryid;
    }

    public void setDiaryid(int diaryid) {
        this.diaryid = diaryid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
