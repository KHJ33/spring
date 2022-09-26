package com.example.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class User_infor implements Data, User {

	@Autowired
	Books book;
	
	Make_file mf;
	Add add_user;
	
	String id_list[] = null;
	String pw_list[] = null;
	String book_list[] = null;
	
//	User_infor() {
//		
//		System.out.println("User_infor 부분입니다.");
//	}
	
	public int add(String id, String pw) {	
		String name;
		String phone;
		String address;
		String total;
		Scanner scan = new Scanner(System.in);
		for(int i=1 ; i<this.id_list.length ; i++) {
			if(this.id_list[i].equals(id))
				return -1;
		}
		add_user.append(id, pw);
		Make_file mf = new Make_file(id+"정보");
		System.out.print("이름을 입력하시오 : ");
		name = scan.nextLine();
		System.out.print("연락처를 입력하시오 : ");
		phone = scan.nextLine();
		System.out.print("주소를 입력하시오 : ");
		address = scan.nextLine();
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(id+"정보"));
			total = "이름 : "+name+"\n연락처 : "+phone+"\n주소 : "+address;
			bw.write(total);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUser(mf);
		return 1;
	}

	
	public int login(String id, String pw) {
		for(int i=1 ; i<this.id_list.length ; i++) {
			if(this.id_list[i].equals(id))
				if(this.pw_list[i].equals(pw))
					return 1;
				else
					return 0;
		}
		return -1;
	}

	public void update_book() {
		String num;
		Scanner scan = new Scanner(System.in);
		System.out.println("1.도서 책 전체 보기 2.책 검색");
		num = scan.nextLine();
		
		if(num.equals("1"))
			book.show_book();
		else if(num.equals("2"))
			book.search_book();
		else
			System.out.println("잘못입력하셨습니다.");
		
	}
	
	public void setUser (Make_file mf) {
		this.mf = mf;
		this.add_user = new Add("user_info");
		String id;
		String pw;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("user_info"));
			id = br.readLine();
			pw = br.readLine();
			
			if(id==null) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("user_info"));
				bw.write("id\n");
				bw.write("pw");
				bw.flush();
				bw.close();
				
				id = "id";
				pw = "pw";
			}
			id_list = id.split(" ");
			pw_list = pw.split(" ");
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrow(String id) {
		Make_file mf = new Make_file(id);
		Scanner scan = new Scanner(System.in);
		String frist;
		String book_name;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(id));
			frist = br.readLine();
			
			if(frist==null) {
				System.out.println("대여중인 책이 없습니다.");
				frist = "";
			}
			else {
				System.out.println("대여중인 책");
				book_list = frist.split(" ");
				for(int i=0 ; i<book_list.length ; i++)
					System.out.print(book_list[i]+" ");
				System.out.println("");
			}
			
			System.out.println("빌릴 책을 입력하시오 : ");
			book_name = scan.nextLine();
			
			if (book.borrow_book(book_name)==1) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(id));
				bw.write(frist+book_name+" ");
				bw.flush();
				bw.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void to_return(String id) {
		Make_file mf = new Make_file(id);
		Scanner scan = new Scanner(System.in);
		String frist;
		String book_name;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(id));
			frist = br.readLine();
			
			if(frist==null) {
				System.out.println("대여중인 책이 없습니다.");
				return;
			}
			else {
				System.out.println("대여중인 책");
				book_list = frist.split(" ");
				for(int i=0 ; i<book_list.length ; i++)
					System.out.print(book_list[i]+" ");
				System.out.println("");
			}
			
			System.out.println("반납할 책을 입력하시오 : ");
			book_name = scan.nextLine();
			
			frist = "";
			for(int i=0 ; i<book_list.length ; i++) {
				if(book_name.equals(book_list[i])) 
					book.return_book(book_name);
				else
					frist = frist + book_list[i] +" ";
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(id));
			bw.write(frist);
			bw.flush();
			bw.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
