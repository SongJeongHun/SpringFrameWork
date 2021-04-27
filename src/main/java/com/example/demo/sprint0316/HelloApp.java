package com.example.demo.sprint0316;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:applicationContext.xml");
        MessageBean bean1 = (MessageBean)ctx.getBean("messageBean");
        MessageBean bean2 = (MessageBean)ctx.getBean("messageBean");
        if (bean1 == bean2){
            System.out.println("same");
        }else{
            System.out.print("different");
        }
        ctx.close();
    }
}
