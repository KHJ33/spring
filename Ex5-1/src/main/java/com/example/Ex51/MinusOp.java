package com.example.Ex51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MinusOp implements OperatorBean {
	
	Operand operand1;
	Operand operand2;
	
	public void setOperand1(Operand operand) {
		this.operand1 = operand;
	}
	
	public void setOperand2(Operand operand) {
		this.operand2 = operand;
	}
	
	public int calc() {
		return operand1.getValue() - operand2.getValue();
	}

}
