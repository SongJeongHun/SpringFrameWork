package com.example.demo.spring0413.ex5_8;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class MessageBeanKo implements MessageBean{
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