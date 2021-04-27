package com.example.demo.spring0406.ex5_2;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

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
