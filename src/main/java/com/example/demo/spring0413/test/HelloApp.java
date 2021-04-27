package com.example.demo.spring0413.test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean = (MessageBean)ctx.getBean("messageBean");
        bean.sayHello("spring");
        ctx.close();
    }
}
