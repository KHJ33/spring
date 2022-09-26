package com.example.Ex53;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PlusOp implements OperatorBean {
	
	Operand operand1;
	Operand operand2;
	

	public void setOperand1(Operand op1) {
		this.operand1 = op1;
	}
	
	public void setOperand2(Operand op2) {
		this.operand2 = op2;
	}
	
	
	public int calc() {
		return operand1.getValue() + operand2.getValue();
	}
}