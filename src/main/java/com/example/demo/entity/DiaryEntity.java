package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by damei on 19/3/30.
 */
@Entity
@Table(name = "diary", schema = "EddyDiary", catalog = "")
public class DiaryEntity {
    private String tag;
    private String date;
    private String location;
    private String mood;
    private String content;
    private int diaryid;
    private String isprivate;
    private String week;
    private String time;
    private String diarypicture;
    private UserEntity userByUserid;

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "mood")
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @Column(name = "diaryid")
    public int getDiaryid() {
        return diaryid;
    }

    public void setDiaryid(int diaryid) {
        this.diaryid = diaryid;
    }

    @Basic
    @Column(name = "isprivate")
    public String getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(String isprivate) {
        this.isprivate = isprivate;
    }

    @Basic
    @Column(name = "week")
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "diarypicture")
    public String getDiarypicture() {
        return diarypicture;
    }

    public void setDiarypicture(String diarypicture) {
        this.diarypicture = diarypicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaryEntity that = (DiaryEntity) o;

        if (diaryid != that.diaryid) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (mood != null ? !mood.equals(that.mood) : that.mood != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (isprivate != null ? !isprivate.equals(that.isprivate) : that.isprivate != null) return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (diarypicture != null ? !diarypicture.equals(that.diarypicture) : that.diarypicture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (mood != null ? mood.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + diaryid;
        result = 31 * result + (isprivate != null ? isprivate.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (diarypicture != null ? diarypicture.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }
}
