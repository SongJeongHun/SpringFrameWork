package com.example.demo.spring0427.ex6_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean1 = (MessageBean)ctx.getBean("proxy");
        bean1.sayHello();
        ctx.close();
    }
}
