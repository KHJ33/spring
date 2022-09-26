package com.example.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Books {
	
	Make_file mf;
	ArrayList<String> as;
	
	public void add_book() {
		String book_name;
		System.out.println("추가하려는 북 정보를 입력하시오 : ");
		Scanner scan = new Scanner(System.in);
		book_name = scan.nextLine();
		
		as.add(book_name + " 대여가능");
		as.sort(null);
		
		update();
		
		System.out.println("북 추가 성공");
		
	}
	
	public void remove_book() {
		int num;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			show_book();
			System.out.println("삭제 하려는 북 번호를 입력하시오(quit=0) : ");
			num = scan.nextInt();
			
			if( num == 0)
				break;
			
			if( num > 0 && num <= as.size()) {
				as.remove(num-1);
				System.out.println("북 삭제 성공");
			}
			else
				System.out.println("없는 번호를 입력하셨습니다.");
		}
		
		update();
		
	}
	
	public void search_book() {
		String s;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색하려는 책을 입력하시오 : ");
		s = scan.nextLine();
		
		System.out.println("검색 결과 입니다.");
		for(int i = 0 ; i < as.size() ; i++) {
			if(s.equals(as.get(i).split(" ")[0])) {
				System.out.println(as.get(i));
				count++;
			}
		}
		if(count == 0)
			System.out.println("검색결과가 없습니다.");
		else
			System.out.println(count + "권 있습니다.");
	}
	
	public void show_book() {
		System.out.println("북 정보");
		System.out.println("-----------");
		
		for(int i = 0 ; i < as.size() ; i++)
			System.out.println((i+1) + ". " + as.get(i));
		
		System.out.println("-----------");
	}
	
	public int borrow_book(String book_name) {
		for(int i = 0 ; i <  as.size() ; i++) {
			if(book_name.equals(as.get(i).split(" ")[0])) {
				if(as.get(i).split(" ")[1].equals("대여가능")) {
					as.set(i, book_name+" 대여중");
					update();
					System.out.println("대여에 성공하셨습니다.");
					return 1;
				}
				else {
					System.out.println("이미 대여중입니다.");
					return 0;
				}
			}
		}
		System.out.println(book_name + " 책이 존재하지 않습니다.");
		return -1;
	}
	
	public void return_book(String book_name) {
		for(int i = 0 ; i <as.size() ; i++) {
			if(book_name.equals(as.get(i).split(" ")[0]))
				if(as.get(i).split(" ")[1].equals("대여중")) {
					as.set(i, book_name+" 대여가능");
					update();
					System.out.println("반납에 성공하셨습니다.");
					return;
				}
		}
		System.out.println("반납에 실패했습니다.");
		return;
	}
	
	
	public void setFile(Make_file mf) {
		String s;
		this.mf = mf;
		
		as = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("books"));
			while((s = br.readLine()) != null ) {
				as.add(s);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void update() {
		String s = "";
		
		for(int i = 0 ; i < as.size() ; i++)
			s = s + as.get(i) + "\n";
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("books"));
			bw.write(s);
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
