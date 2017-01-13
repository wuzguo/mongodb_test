package com.wzguo.mongo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/1/10.
 */
public class User implements Serializable {
    private int uId;

    private String userName;

    private int age;

    private String gender;

    private Date birth;

    private BigDecimal wealth;

    private double weight;

    private String addr;


    public User() {
    }

    public User(int id, String userName, int age, String gender) {
        this.uId = id;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", wealth=" + wealth +
                ", weight=" + weight +
                ", addr='" + addr + '\'' +
                '}';
    }
}
