package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by damei on 19/3/30.
 */
@Entity
@Table(name = "user", schema = "EddyDiary", catalog = "")
public class UserEntity {
    private String userid;
    private String username;
    private String userpicture;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpicture")
    public String getUserpicture() {
        return userpicture;
    }

    public void setUserpicture(String userpicture) {
        this.userpicture = userpicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userpicture != null ? !userpicture.equals(that.userpicture) : that.userpicture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpicture != null ? userpicture.hashCode() : 0);
        return result;
    }
}
