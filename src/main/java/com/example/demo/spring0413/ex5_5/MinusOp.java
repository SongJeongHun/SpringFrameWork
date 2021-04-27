package com.example.demo.spring0413.ex5_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("defaultOperator")
public class MinusOp implements OperatorBean {

    Operand operand1;

    Operand operand2;
    @Autowired
    public void setOperand1(Operand op1) { this.operand1 = op1; }
    @Autowired
    public void setOperand2(Operand op2) {
        this.operand2 = op2;
    }
    public int calc(){
        return operand1.getValue() - operand2.getValue();
    }
}
