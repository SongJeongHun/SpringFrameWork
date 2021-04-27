package com.example.demo.spring0323;

public class MinusOp implements OperatorBean {
    public void setOperand1(int operand1) { this.operand1 = operand1; }
    public void setOperand2(int operand2) { this.operand2 = operand2; }
    int operand1;
    int operand2;
    public int calc(){
        return operand1 - operand2;

    }
}
