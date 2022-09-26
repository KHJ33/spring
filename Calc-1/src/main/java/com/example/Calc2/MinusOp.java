package com.example.Calc2;

import org.springframework.beans.factory.annotation.Autowired;

public class MinusOp implements OperatorBean {
	Operand operand1;
	Operand operand2;
	
	@Autowired
	public void setOperand1(Operand operand) {
		this.operand1 = operand;
	}
	@Autowired
	public void setOperand2(Operand operand) {
		this.operand2 = operand;
	}
	
	public int calc() {
		return operand1.getValue() - operand2.getValue();
	}

}
