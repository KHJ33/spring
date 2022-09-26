package com.example.Ex61;

public class MessageBeanImpl implements MessageBean { 
	
	private String name;
	
	public void waitAMoment(int msec) { 
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	
	public void sayHello() {
		waitAMoment(5000);
		System.out.println("Hello, " + name + "!"); 
	}
	
	
	public void setName(String name) { 
		this.name = name;
	} 
	
}
