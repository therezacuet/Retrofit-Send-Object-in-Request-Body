package com.thereza.retrofit2.model;

/**
 * Created by theReza on 11/17/2017.
 */

public class User {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private String phoneNo;
    private String password;

    public User(String name, String email, String address, String phoneNo, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
