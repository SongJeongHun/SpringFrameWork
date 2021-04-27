package com.example.demo.spring0413.ex5_8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean = (MessageBean)ctx.getBean("messageBean");
        bean.sayHello("spring");
        ctx.close();
    }
}
