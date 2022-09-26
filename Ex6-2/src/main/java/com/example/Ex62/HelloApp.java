package com.example.Ex62;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new
				GenericXmlApplicationContext("classpath*:appctxEx6_2.xml");
		
		MessageBean bean = (MessageBean)ctx.getBean("proxy");
		bean.sayHello();
		ctx.close();
	}
} 
