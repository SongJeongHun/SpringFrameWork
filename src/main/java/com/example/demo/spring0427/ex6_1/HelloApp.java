package com.example.demo.spring0427.ex6_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean1 = (MessageBean)ctx.getBean("messageBean");
        bean1.sayHello();
        ctx.close();
    }
}
