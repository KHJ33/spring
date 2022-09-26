package com.example.Ex73;

import org.springframework.context.support.AbstractApplicationContext; 
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_3 {
	private static MemberDao memberDao; 
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
		
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member mem = memberDao.selectByEmail("madvirus@madvirus.net"); 
		System.out.println(mem.getName());
		ctx.close();

	}
}