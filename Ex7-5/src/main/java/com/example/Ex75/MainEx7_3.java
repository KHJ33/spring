package com.example.Ex75;

import org.springframework.context.support.AbstractApplicationContext; 
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_3 {
	private static MemberDao memberDao; 
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
		
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member = memberDao.selectByEmail("madvirus@madvirus.net");
		
		try { 
			member.changePassword("aaaa", "1234"); // (oldpassword, newpassword) } 
			
		} catch (Exception e) { e.printStackTrace(); }
		
		memberDao.update(member);
		member = memberDao.selectByEmail("madvirus@madvirus.net"); 
		System.out.println(member.getPassword());
		
		ctx.close();

	}
}