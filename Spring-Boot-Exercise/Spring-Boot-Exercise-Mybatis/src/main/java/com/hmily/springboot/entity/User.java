package com.hmily.springboot.entity;

import javax.persistence.Column;

/**
 * Created by zyzhmily on 2019/3/19.
 */
public class User {
    private int id;

    @Column(name="user_name")
    private String name;

    private String address;

    private String phone;

    private int score;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
