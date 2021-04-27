package com.example.demo.spring0413.ex5_7;

import org.springframework.stereotype.Component;

@Component("default1")
public class MessageBeanEn implements MessageBean { public void sayHello(String name) {
    System.out.println("Hello," + name); }
}