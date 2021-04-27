package com.example.demo.spring0413.ex57a;


public class MessageBeanKo implements MessageBean{
    public void sayHello(String name) {
    System.out.println("안녕하세요," + name);
    }

    public void initialize() throws Exception {
        System.out.println("initMessage()실행");
    }
    public void close() throws Exception {
        System.out.println("finishMessage()실행");
    }
}