package com.example.demo.middleProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Scanner;

@Configuration
public class JavaConfig {
    @Bean
    public LibraryManagementSystem LMS(){
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.setFh(fh());
        setTarget();
        lms.setLibrary(getBookList());
        lms.setSc(scanner());
        lms.setUserList(getUserList());
        return lms;
    }
    @Bean
    public FileHandler fh(){
        return new FileHandler();
    }
    @Bean
    public Scanner scanner() { return new Scanner(System.in); }
    @Bean
    public ArrayList<User> getUserList(){ return fh().getUserList(); }
    @Bean
    public void setTarget(){ fh().setTarget("UserTable"); }
    @Bean
    public ArrayList<Book> getBookList(){
        return fh().getBookList();
    }
}
