package com.example.Calc3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PlusOp implements OperatorBean {
	@Resource(name="op1")
	Operand operand1;
	@Resource(name="op2")
	Operand operand2;
	

	//public void setOperand1(Operand operand) {
	//	this.operand1 = operand;
	//}
	
	//public void setOperand2(Operand operand) {
	//	this.operand2 = operand;
	//}
	
	
	public int calc() {
		return operand1.getValue() + operand2.getValue();
	}
}