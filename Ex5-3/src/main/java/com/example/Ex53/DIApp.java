package com.example.Ex53;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		OperatorBean operator = (OperatorBean)ctx.getBean("operatorBean");
		int value = operator.calc();

		System.out.println("The result value: " + value);

		ctx.close();
	}
}
