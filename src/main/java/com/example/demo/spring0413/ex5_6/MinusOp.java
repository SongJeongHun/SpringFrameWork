package com.example.demo.spring0413.ex5_6;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("defaultOperator")
public class MinusOp implements OperatorBean, InitializingBean, DisposableBean {

    Operand operand1;

    Operand operand2;
    @Autowired
    public void setOperand1(Operand op1) { this.operand1 = op1; }
    @Autowired
    public void setOperand2(Operand op2) {
        this.operand2 = op2;
    }
    public int calc(){
        System.out.println("calc() 실행");
        return operand1.getValue() - operand2.getValue();
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("MinusOP.destroy()실행");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MinusOP.afterPropertiesSet()실행");
    }
}