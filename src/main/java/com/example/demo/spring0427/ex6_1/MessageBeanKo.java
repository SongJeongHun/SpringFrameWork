package com.example.demo.spring0427.ex6_1;

public class MessageBeanKo implements MessageBean {
    private String name;
    public void waitAMoment(int msec){
        try{
            Thread.sleep(msec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void sayHello() {
        waitAMoment(5000);
        System.out.println("Hello," + name);
    }
    public void setName(String name){
        this.name = name;
    }
}