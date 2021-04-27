package com.example.demo.spring0413.ex57a;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new
                GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean = (MessageBean)ctx.getBean("messageBean1");
        bean.sayHello("Spring");
        ctx.close();
    }
}
