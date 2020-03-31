package com.springcloud.scprovider.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  UserInfo implements Serializable {
    INSTANCE;
    private String userName;
    private String address;
    private Integer age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
