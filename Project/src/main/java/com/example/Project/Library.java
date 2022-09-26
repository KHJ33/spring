package com.example.Project;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Library {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new
				GenericXmlApplicationContext("classpath*:applicationContext.xml");
		
		//Data data = (Data)ctx.getBean("user_data");
		
		while(true) {
			System.out.println("1.사용자 , 2.관리자 3.out");
			Scanner scan = new Scanner(System.in);
			String num = scan.nextLine();
			String id;
			String pw;
		
			if(num.equals("1")) {
				while(true) {
					Data data = (Data)ctx.getBean("user_data");
					System.out.println("1.사용자 로그인 2.회원가입 3.quit");
					num = scan.nextLine();
					
					if(num.equals("1")) {
						System.out.print("사용자 아이디를 입력하시오 : ");
						id = scan.nextLine();
						System.out.print("사용자 비밀번호를 입력하시오 : ");
						pw = scan.nextLine();
						
						if(data.login(id, pw) == 1) {
							User user = (User)ctx.getBean("user_data");
							while(true) {
								System.out.println(id+"님 페이지");
								System.out.println("1.도서 책 보기 2.책 대여 3.책 반납 4.quit");
								num = scan.nextLine();
								if(num.equals("1"))
									data.update_book();
								else if(num.equals("2"))
									user.borrow(id);
								else if(num.equals("3"))
									user.to_return(id);
								else if(num.equals("4"))
									break;
								else
									System.out.println("잘못입력하셨습니다.");
							}
						}
						else if(data.login(id, pw)==0)
							System.out.println("비밀번호를 확인하시오.");
						else
							System.out.println("해당 아이디가 없습니다.");
						
					}
					else if(num.equals("2")) {
						System.out.print("추가 하실 아이디를 입력하시오 : ");
						id = scan.nextLine();
						System.out.print("비밀번호를 입력하시오 : ");
						pw = scan.nextLine();
						if(data.add(id, pw) == 1)
							System.out.println("성공적으로 추가했습니다.");
						else
							System.out.println("사용중인 아이디 입니다.");
					}
					else if(num.equals("3"))
						break;
					else
						System.out.println("잘못입력하셨습니다.");
				}
			}
			else if(num.equals("2")) {
				System.out.print("관리자 아이디를 입력하시오 : ");
				id = scan.nextLine();
				System.out.print("관리자 비밀번호를 입력하시오 : ");
				pw = scan.nextLine();
				Data data = (Data)ctx.getBean("manager");
				
				if(data.login(id, pw)==1) {

					while(true) {
						System.out.println("관리자모드를 실행합니다.");
						System.out.println("1.북 정보 업데이트 2.관리자 추가 3.quit");
						num = scan.nextLine();
						if(num.equals("1"))
							data.update_book();
						else if(num.equals("2")) {
							System.out.print("추가 하실 아이디를 입력하시오 : ");
							id = scan.nextLine();
							System.out.print("비밀번호를 입력하시오 : ");
							pw = scan.nextLine();
							
							if(data.add(id, pw) == 1)
								System.out.println("성공적으로 추가했습니다.");
							else
								System.out.println("사용중인 아이디 입니다.");
						}
						else if(num.equals("3"))
							break;
						else
							System.out.println("잘못입력하셨습니다.");
					}
				}
				else
					System.out.println("실패");
			}
			else if(num.equals("3"))
				break;
			else
				System.out.println("잘못입력하셨습니다.");
			
		}
		
		ctx.close();
	}
} 