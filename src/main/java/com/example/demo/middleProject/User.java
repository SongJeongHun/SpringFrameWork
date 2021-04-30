package com.example.demo.middleProject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Scope("prototype")
public class User {
    String ID;
    String password;
    String name;
    String phoneNum;
    String address;
    ArrayList<String> bookID;

    public User(String ID, String password, String name, String phoneNum, String address, ArrayList<String> bookID) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.bookID = bookID;
    }

    public ArrayList<String> getBook() { return bookID; }

    public void setBook(ArrayList<String> bookID) { this.bookID = bookID; }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
