package com.example.Calc;

public class PlusOp implements OperatorBean {
	int operand1;
	int operand2;
	
	PlusOp (int operand1, int operand2){
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public int calc() {
		return operand1 + operand2;
	}
}
