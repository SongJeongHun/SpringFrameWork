package com.example.demo.spring0413.ex5_7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        MessageBean bean = (MessageBean)ctx.getBean("default");
        bean.sayHello("spring");
        ctx.close();
    }
}
