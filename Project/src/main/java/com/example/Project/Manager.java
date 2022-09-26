package com.example.Project;

import java.io.*;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Manager implements Data {

	@Autowired
	Books book;
	
	Add add_manager;
	
	String id = "";
	String pw = "";
	String id_list[] = null;
	String pw_list[] = null;
	
	
	Manager(Make_file mf,Add add_manager) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("manager_info"));
			id = br.readLine();
			pw = br.readLine();
			
			if(id==null) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("manager_info"));
				bw.write("id aaa\n");
				bw.write("pw 111");
				bw.flush();
				bw.close();
				
				id = "id aaa";
				pw = "pw 111";
			}
			id_list = id.split(" ");
			pw_list = pw.split(" ");
			
			this.add_manager = add_manager;
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int login(String id,String pw) {
		for(int i=1 ; i<this.id_list.length ; i++) {
			if(this.id_list[i].equals(id) && this.pw_list[i].equals(pw))
				return 1;
		}
		return -1;
	}
	
	
	public void update_book() {
		String num;
		while(true) {
			System.out.println("북 정보 업데이트 모드입니다.");
			System.out.println("1.모든 북 보기 2.북 추가 3.북 삭제 4.quit");
			Scanner scan = new Scanner(System.in);
			num = scan.nextLine();
			if(num.equals("1"))
				book.show_book();
			else if(num.equals("2"))
				book.add_book();
			else if(num.equals("3"))
				book.remove_book();
			else if(num.equals("4"))
				break;
			else
				System.out.println("잘못입력하셨습니다.");
		}
	}
	
	public int add(String id, String pw) {	
		for(int i=1 ; i<this.id_list.length ; i++) {
			if(this.id_list[i].equals(id))
				return -1;
		}
		add_manager.append(id, pw);
		try {
			BufferedReader br = new BufferedReader(new FileReader("manager_info"));
			id_list = br.readLine().split(" ");
			pw_list = br.readLine().split(" ");
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	

}
