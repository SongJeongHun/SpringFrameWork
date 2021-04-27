package com.example.demo.middleProject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String args[]){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        LibraryManagementSystem lms = (LibraryManagementSystem)ctx.getBean("LMS");
        lms.popUserMenu();
        while(lms.loop){}
        ctx.close();
    }
}
