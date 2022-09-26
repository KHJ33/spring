package com.example.Ex58;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanKo implements MessageBean{

	public void sayHello(String name) {
		System.out.println("sayHello()실행");
		System.out.println("안녕하세요," + name);
	}
	
	public void init() throws Exception {
	System.out.println("initMessage() 실행");
	}
	public void finish() throws Exception {
	System.out.println("finishMessage() 실행");
	}

}