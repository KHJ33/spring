package com.example.Ex75;

import java.util.Date;
import org.springframework.context.support.AbstractApplicationContext; 
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_3 {
	private static MemberDao memberDao; 
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
		
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member = new Member("guest1@gmail.com", "aaa", "Mr.Lee", new Date()); 
		memberDao.insert(member);
		
		System.out.println(member.getId());
		
		ctx.close();

	}
}