package com.example.Ex56;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("defaultOperator")
public class MinusOp implements OperatorBean,InitializingBean, DisposableBean {
	
	Operand operand1;
	Operand operand2;
	
	@Autowired
	public void setOperand1(Operand op1) {
		this.operand1 = op1;
	}
	@Autowired
	public void setOperand2(Operand op2) {
		this.operand2 = op2;
	}
	
	public int calc() {
		System.out.println("calc()호출");
		return operand1.getValue() - operand2.getValue();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	System.out.println("MinusOp.afterPropertiesSet() 실행");
	}
	@Override
	public void destroy() throws Exception {
	System.out.println("MinusOp.destroy() 실행");
	}
}
