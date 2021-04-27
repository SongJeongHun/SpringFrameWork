package com.example.demo.spring0330;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class PlusOp implements OperatorBean {
    @Resource(name = "op1")
    Operand operand1;
    @Resource(name = "op2")
    Operand operand2;

    public void setOperand1(Operand operand) {
        this.operand1 = operand;
    }

    public void setOperand2(Operand operand) {
        this.operand2 = operand;
    }

    public int calc(){
        return operand1.getValue() + operand2.getValue();
    }
}
