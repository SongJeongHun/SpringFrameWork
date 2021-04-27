package com.example.demo.spring0323;

public class PlusOp implements OperatorBean{
    int operand1;
    int operand2;
    public void setOperand1(int value){ this.operand1 = value;}
    public void setOperand2(int value){ this.operand2 = value;}
    public int calc(){
        return operand1 + operand2;
    }
}
