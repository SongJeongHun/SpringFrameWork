package com.example.demo.spring0413.test;


public class MessageBeanKo implements MessageBean {
    public void sayHello(String name) {
    System.out.println("안녕하세요," + name);
    }

    private void initMessage() {
        System.out.println("initMessage()실행");
    }

    private void finishMessage() {
        System.out.println("finishMessage()실행");
    }
}