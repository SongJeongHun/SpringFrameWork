//package com.example.demo.spring0406.ex5_1;
//
//
//import com.example.demo.spring0323.OperatorBean;
//import com.example.demo.spring0406.JavaConfig;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class DIApp2 {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//        OperatorBean operator = (OperatorBean) ctx.getBean("operatorBean");
//        int value = operator.calc();
//        System.out.println("The result value: " + value);
//        ctx.close();
//    }
//}