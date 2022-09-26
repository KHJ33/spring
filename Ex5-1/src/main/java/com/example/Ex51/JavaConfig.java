package com.example.Ex51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
	
	@Bean
	public OperatorBean operatorBean() {
		OperatorBean op = new MinusOp();
		op.setOperand1(op1());
		op.setOperand2(op2());
		return op;
		
	}
	
	@Bean
	@Scope("prototype")
	public Operand op1() {
		Operand operand = new Operand();
		operand.setValue(10);
		return operand;
	}
	
	@Bean
	@Scope("prototype")
	public Operand op2() {
		Operand operand = new Operand();
		operand.setValue(20);
		return operand;
	}

}
