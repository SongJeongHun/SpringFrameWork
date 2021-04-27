//package com.example.demo.spring0406.ex5_2;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class DIApp2 {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//        OperatorBean operator1 = (OperatorBean) ctx.getBean("operatorBean");
//        OperatorBean operator2 = (OperatorBean) ctx.getBean("operatorBean");
//        System.out.println("The result is "+ operator1.calc());
//        System.out.println("op1:"+operator1+", op2:"+operator2);
//        ctx.close();
//    }
//}